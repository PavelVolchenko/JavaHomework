package hw03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class task03 {
    /*  3) *Дополнительно. Реализовать алгоритм сортировки слиянием    */
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int arraySize = iScanner.nextInt();
        iScanner.close();
        int[] array = fillArray(arraySize);
        System.out.print("Input array: ");
        System.out.println(Arrays.toString(array));
        int[] result = mergeSortRecursive(array);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(result));
    }
    public static int[] mergeSortRecursive(int[] array) {
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        return mergeSort(buffer1, buffer2, 0, array.length);
    }
    private static int[] mergeSort(int[] buffer1, int[] buffer2, int start, int end) {
        if (start >= end - 1) {
            return buffer1;
        }
        int mid = start + (end - start) / 2;
        int[] sort1 = mergeSort(buffer1, buffer2, start, mid);
        int[] sort2 = mergeSort(buffer1, buffer2, mid, end);
        int index1 = start;
        int index2 = mid;
        int dest = start;
        int[] result = (sort1 == buffer1) ? buffer2 : buffer1;
        while (index1 < mid && index2 < end) {
            result[dest++] = (sort1[index1] < sort2[index2]) ? sort1[index1++] : sort2[index2++];
        }
        while (index1 < mid) {
            result[dest++] = sort1[index1++];
        }
        while (index2 < end) {
            result[dest++] = sort2[index2++];
        }
        return result;
    }
    public static int[] fillArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }
        return array;
    }
}
