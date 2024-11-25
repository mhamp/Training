package dsa.searching;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Performs a binary search on the given array to find the target value.
     * If the array is not sorted, it will first sort the array in ascending order.
     *
     * @param array  The array of integers to search in.
     *               If unsorted, the array will be sorted.
     * @param target The integer value to search for.
     * @return The index of the target value if found; -1 otherwise.
     */
    public int binarySearch(int[] array, int target) {
        int low, high, half;
        // Ensure the array is sorted before performing the search.
        if (!isSorted(array)) {
            Arrays.sort(array);
        }
        // Initialize the low and high bounds for the search range.
        low = 0;
        high = array.length - 1;
        // Continue searching while the low bound does not exceed the high bound.
        while (low <= high) {
            // Calculate the middle index.
            half = (low + high) / 2;
            // Retrieve the value at the middle index.
            int middleNumber = array[half];
            // Check if the middle value matches the target.
            if (target == middleNumber) {
                return half; // Return the index if the target is found.
            }
            // If the target is less than the middle value, search the left half.
            if (target < middleNumber) {
                high = half - 1;
            } else {
                // Otherwise, search the right half.
                low = half + 1;
            }
        }
        // If the target is not found, return -1.
        return -1;
    }
    /**
     * Uses the built-in binary search method from the {@link Arrays} class to find the target value
     * in the given array. The array must be sorted in ascending order prior to calling this method.
     *
     * @param array  The array of integers to search in. Must be sorted in ascending order.
     * @param target The integer value to search for.
     * @return The index of the target value if found.
     *         If the target is not found, returns <code>(-(insertion point) - 1)</code>,
     *         where the insertion point is the index at which the target would be inserted to maintain the sorted order.
     * @throws IllegalArgumentException If the input array is null.
     */
    public static int builtInBinarySearch(int[] array, int target){
        return Arrays.binarySearch(array, target);
    }

    /**
     * Performs a binary search on a sorted array to find the target value using recursion.
     *
     * @param array  The sorted array of integers to search in.
     * @param target The integer value to search for.
     * @return The index of the target value if found; -1 otherwise.
     */
    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    /**
     * Helper method to perform the recursive binary search.
     *
     * @param array The sorted array of integers to search in.
     * @param target The integer value to search for.
     * @param low The lower bound of the search range.
     * @param high The upper bound of the search range.
     * @return The index of the target value if found; -1 otherwise.
     */
    private static int binarySearchRecursive(int[] array, int target, int low, int high) {
        // Base case: If the range is invalid, the target is not in the array.
        if (low > high) {
            return -1;
        }

        // Calculate the middle index.
        int mid = low + (high - low) / 2;

        // Check if the target is at the middle.
        if (array[mid] == target) {
            return mid;
        }

        // If the target is less than the middle value, search the left half.
        if (target < array[mid]) {
            return binarySearchRecursive(array, target, low, mid - 1);
        }

        // Otherwise, search the right half.
        return binarySearchRecursive(array, target, mid + 1, high);
    }


    public static boolean isAscendingOrder(int[] a)
    {
        for ( int i = 0; i < a.length - 1 ; i++ ) {
            if ( a[i] > a[i+1] )
                return false;
        }
        return true;
    }


    // Same with Desending order
    public static boolean isDescendingOrder(int[] a)
    {
        for ( int i = 0; i < a.length - 1 ; i++ ) {
            if ( a[i] < a[i+1] )
                return false;
        }
        return true;
    }


    public static boolean isSorted(int[] a)
    {
        return isAscendingOrder(a) || isDescendingOrder(a);
    }


}
