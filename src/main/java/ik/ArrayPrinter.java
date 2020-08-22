package ik;

import java.util.StringJoiner;

/**
 * Utility class for log messages during execution.
 */
public class ArrayPrinter {

    public static void printIntArrayToConsole(int[] array, String message) {
        StringJoiner stringJoiner = new StringJoiner(", ", message + " [","]");
        for (int i : array) {
            stringJoiner.add(String.valueOf(i));
        }
        System.out.println(stringJoiner);
    }
}
