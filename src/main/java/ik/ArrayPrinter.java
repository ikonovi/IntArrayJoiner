package ik;

/**
 * Utility class for log messages during execution.
 */
public class ArrayPrinter {

    public static void printIntArrayToConsole(int[] array) {
        String output;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                output = "" + array[i] + ", ";
            } else {
                output = "" + array[i] + "\n";
            }
            System.out.print(output);
        }
    }

    public static void printIntArrayToConsole(int[] array, String message) {
        System.out.println(message);
        printIntArrayToConsole(array);
    }
}
