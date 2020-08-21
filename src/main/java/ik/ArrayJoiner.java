package ik;

import java.util.Arrays;

public class ArrayJoiner {

    private final int[] array1;
    private final int[] array2;
    private int[] arrayJoined;

    public ArrayJoiner(String fileName1, String fileName2) {
        Reader intArrayReader = new ArrayReader();
        this.array1 = intArrayReader.readArrayFromFile(fileName1);
        ArrayPrinter.printIntArrayToConsole(this.array1, "Initialized array1:");
        this.array2 = intArrayReader.readArrayFromFile(fileName2);
        ArrayPrinter.printIntArrayToConsole(this.array2, "Initialized array2:");
    }

    /**
     * Consolidates both arrays with numbers.
     * Note:
     * Step order makes sence. 1 - concatenate, 2 - sort, 3 - remove duplicates.
     * Removing duplications depends on sorting performed before.
     */
    public void join() {
        // Step #1
        this.arrayJoined = concatenate(this.array1, this.array2);
        ArrayPrinter.printIntArrayToConsole(this.arrayJoined, "Concatenated array:");
        // Step #2
        bubbleSort(this.arrayJoined);
        ArrayPrinter.printIntArrayToConsole(this.arrayJoined, "Sorted array:");
        // Step #3
        this.arrayJoined = removeDuplicatesInSortedArray(this.arrayJoined);
        ArrayPrinter.printIntArrayToConsole(this.arrayJoined, "Removed duplicates array:");
    }

    /**
     * <u>Prerequisite</u>: array passed this function as argument, must be sorted before.
     *
     * @param arr array to be erased from duplicates.
     */
    private int[] removeDuplicatesInSortedArray(int[] arr) {
        //Arrays.sort(arrayJoined);
        int[] newArr;
        int[] tmp = new int[arr.length];
        int j = 0;
        if (arr.length != 0 && arr.length != 1) {
            // if it's not empty or does not contain one element.
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    // current element is not equal next element, then store it.
                    tmp[j++] = arr[i];
                }
            }
            // Last element is never stored. Therefore let's store it.
            tmp[j++] = arr[arr.length - 1];

            newArr = new int[j];
            if (j >= 0) System.arraycopy(tmp, 0, newArr, 0, j);
        } else {
            newArr = arr;
        }
        return newArr;
    }

    private void bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            int temp;
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    private int[] concatenate(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int idx = 0;
        for (int elem : arr1) {
            result[idx] = elem;
            idx++;
        }
        for (int elem : arr2) {
            result[idx] = elem;
            idx++;
        }
        return result;
    }

    private int[] removeDuplicatesWithJava8Streams(int[] ints) {
        return Arrays.stream(ints).distinct().toArray();
    }

    private int[] concatenateWithArrayCopy(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    public int[] getArrayJoined() {
        return arrayJoined;
    }
}
