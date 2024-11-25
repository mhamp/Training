package dsa.sorting;

import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    /**
     * Implementation of the Merge Sort algorithm.
     * Merge Sort is a divide-and-conquer sorting algorithm that splits an array into halves,
     * recursively sorts each half, and then merges the sorted halves back together.
     * Sorts the given array using the Merge Sort algorithm.
     *
     * @param array The array to be sorted.
     */
    public static void mergeSort(int[] array) {
        int length = array.length;

        // Base case: if the array has 1 or no elements, it is already sorted.
        if (length < 2) {
            return;
        }

        // Find the middle index to split the array into two halves.
        int midIndex = length / 2;

        // Create two sub-arrays for the left and right halves.
        int[] arrayLeft = new int[midIndex];
        int[] arrayRight = new int[length - midIndex];

        // Copy elements into the left sub-array.
        for (int i = 0; i < midIndex; i++) {
            arrayLeft[i] = array[i];
        }

        // Copy elements into the right sub-array.
        for (int i = midIndex; i < length; i++) {
            arrayRight[i - midIndex] = array[i];
        }

        // Recursively sort the left and right sub-arrays.
        mergeSort(arrayLeft);
        mergeSort(arrayRight);

        // Merge the sorted sub-arrays back into the original array.
        merge(array, arrayLeft, arrayRight);
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param array The destination array where the merged result is stored.
     * @param left  The left sorted sub-array.
     * @param right The right sorted sub-array.
     */
    public static void merge(int[] array, int[] left, int[] right) {
        int leftSize = left.length; // Length of the left sub-array.
        int rightSize = right.length; // Length of the right sub-array.
        int i = 0, j = 0, k = 0; // Pointers for left, right, and main array.

        // Compare elements from both sub-arrays and add the smaller one to the main array.
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left sub-array.
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right sub-array.
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }



    /**
     * Given a linked list, sort it in O(n log n) time and constant space.
     *
     * For example, the linked list 4 -> 1 -> -3 -> 99 should become -3 -> 1 -> 4 -> 99.
     * @src Daily Coding Problem: Problem #169 [Medium] Google
     */
    public static void sortLinkedList(LinkedList<Integer> list){
        int length = list.size();
        if (length < 2){
            return;
        }
        LinkedList<Integer> left = new LinkedList<>(), right = new LinkedList<>();
        int mid = length / 2;

        for (int i = 0; i < mid; i++){
            left.add(list.get(i));
        }

        for (int i = mid; i < length; i++) {
            right.add(list.get(i));
        }

        sortLinkedList(left);
        sortLinkedList(right);

        mergeLinkedList(list, left, right);
    }

    private static void mergeLinkedList(LinkedList<Integer> list, LinkedList<Integer> left, LinkedList<Integer> right) {
        list.clear();
        int leftSize = left.size();
        int rightSize = right.size();
        int i = 0, j = 0;
        while (i < leftSize && j < rightSize) {
            if(left.get(i) <= right.get(j)){
                list.add(left.get(i));
                i++;
            } else {
                list.add(right.get(j));
                j++;
            }
        }

        while(i < leftSize){
            list.add(left.get(i));
            i++;
        }

        while(j < rightSize){
            list.add(right.get(j));
            j++;
        }
    }
}
