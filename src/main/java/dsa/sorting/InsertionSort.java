package dsa.sorting;

public class InsertionSort {
    /**
     * Insertion Sort<br><br>
     * Description: Builds the final sorted array one item at a time, by repeatedly taking the next item and
     * inserting it into the correct position among the items already sorted.<br><br>
     * @eval Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Stability: Stable
     * @param array
     */
    public static int[] insertionSort(int[] array) {
        // Because first element at array[0] is already sorted, loop starts at i = 1.
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
