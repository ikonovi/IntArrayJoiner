package ik;

import java.io.*;
import java.net.URL;

public class ArrayReader implements Reader {

    @Override
    public int[] readArrayFromFile(String fileName) {
        return parseStringToIntArray(readFile(getFileFromResources(fileName)));
    }

    private int[] parseStringToIntArray(String string) {
        String[] strArray = string.split("\\s");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    private String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        if (file != null) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File name is required.");
        }
        return stringBuilder.toString();
    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File was not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
