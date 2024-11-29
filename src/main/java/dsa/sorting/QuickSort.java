package dsa.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSort {
    /**
     * <b>Quick Sort with standard Single-loop Partition</b><br>
     * For most practical use cases, the standard single-loop partitioning is preferable due to its simplicity and decent performance.
     *
     * Uses a single loop (for loop) with straightforward checks.
     * Comparisons are linear with fewer conditionals, leading to slightly better performance for randomly distributed data.
     * Performs more swaps, even when some elements are already in the correct partition.
     *
     * Performance: Standard partitioning with a single loop is generally faster due to fewer conditionals and simpler pointer management. The nested implementation could outperform in scenarios where the data is close to sorted, as it minimizes unnecessary swaps.
     * Clarity: The single-loop approach is easier to understand and maintain.
     * Robustness: The nested approach is slightly better at handling edge cases, such as equal elements or closely positioned pivots.
     * Pivot Choice: Random pivoting in the nested implementation is an improvement over always choosing the last element.
     * @param arr
     */
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    // QuickSort function
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(arr, low, pivotIndex - 1);  // Left partition
            quickSort(arr, pivotIndex + 1, high); // Right partition
        }
    }

    // Partition function to rearrange elements
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element
                swap(arr, i, j);
            }
        }

        // Place the pivot in the correct position
        swap(arr, i + 1, high);
        return i + 1; // Return pivot index
    }

    // Utility function to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Code with John implementation
     * The nested while loops implementation has advantages and disadvantages compared to the standard single-loop partitioning approach.
     * Advantages:
     * Reduces the number of swaps, as it swaps elements only when both pointers are at incorrect positions.
     * Can be faster for arrays where the values are already partially sorted or contain few misplaced elements.
     * Disadvantages:
     * The nested loops introduce additional complexity in control flow, increasing the cost of each iteration.
     * The leftPointer and rightPointer checks make the partitioning slightly more expensive in terms of comparison operations.
     *
     * @src <a href="https://www.youtube.com/watch?v=h8eyY7dIiN4&t=839s">Quicksort Sort Algorithm in Java by 'Coding with John'</a>
     * @param lowIndex
     * @param highIndex
     */
    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }
        // Choosing a random pivot for performance increase in average cases over last position in array
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order.
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        if(array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }
    /**
     * A functional-style implementation of the QuickSort algorithm in Java.
     * <p>
     * This method uses recursion and the Java Stream API to partition the input list into
     * two sublists (elements less than or equal to the pivot, and elements greater than the pivot),
     * and then recursively sorts those sublists. The final sorted list is constructed by
     * combining the sorted "less" partition, the pivot, and the sorted "greater" partition.
     * </p>
     *
     * @param list the list of integers to be sorted (must not be null)
     * @return a new sorted list of integers in ascending order
     * @throws NullPointerException if the input list is null
     *
     * <h2>Pros</h2>
     * <ul>
     *   <li><b>Immutability:</b> The input list is not modified. Instead, new lists are created
     *       for partitions, making the implementation safer in multi-threaded environments or
     *       scenarios where immutability is preferred.</li>
     *   <li><b>Declarative Style:</b> The use of Streams and functional constructs like
     *       {@code filter} makes the implementation clean, expressive, and easy to understand.</li>
     *   <li><b>Readable and Elegant:</b> The logic closely mirrors the mathematical definition
     *       of QuickSort, making it a good educational example of functional programming in Java.</li>
     * </ul>
     *
     * <h2>Cons</h2>
     * <ul>
     *   <li><b>Memory Inefficiency:</b> New lists are created at every recursive step for the
     *       partitions, leading to higher memory usage compared to in-place sorting algorithms.</li>
     *   <li><b>Performance Overhead:</b> Using {@code Stream} operations and collecting results
     *       introduces additional computational overhead. This implementation is slower than
     *       traditional in-place QuickSort, especially for large datasets.</li>
     *   <li><b>Stack Overflow Risk:</b> Java does not optimize tail-recursive calls, so for
     *       very large lists, this implementation risks a {@code StackOverflowError} due to
     *       deep recursion.</li>
     *   <li><b>Limited Practical Use:</b> While elegant, this approach is not well-suited for
     *       production-grade sorting due to its inefficiencies and limitations.</li>
     * </ul>
     *
     * <h2>Example Usage</h2>
     * <pre>{@code
     * List<Integer> unsortedList = List.of(10, 7, 8, 9, 1, 5);
     * List<Integer> sortedList = FunctionalQuickSort.quickSort(unsortedList);
     * System.out.println(sortedList); // Output: [1, 5, 7, 8, 9, 10]
     * }</pre>
     *
     * <h2>Performance Characteristics</h2>
     * <ul>
     *   <li><b>Time Complexity:</b> Average case is O(n log n), but the worst case is O(n^2)
     *       if the pivot selection is poor (e.g., sorted input without randomization).</li>
     *   <li><b>Space Complexity:</b> O(n) due to the creation of new lists and recursion stack usage.</li>
     * </ul>
     */
    public static List<Integer> quickSort(List<Integer> list) {
        // Base case: if the list has 0 or 1 elements, it's already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Choose a pivot (e.g., the first element)
        int pivot = list.get(0);

        // Partition the list into two sublists
        List<Integer> less = list.stream()
                .skip(1) // Exclude the pivot
                .filter(x -> x <= pivot) // Elements less than or equal to pivot
                .collect(Collectors.toList());

        List<Integer> greater = list.stream()
                .skip(1) // Exclude the pivot
                .filter(x -> x > pivot) // Elements greater than pivot
                .collect(Collectors.toList());

        // Recursively sort the partitions and combine the results
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(quickSort(less)); // Add sorted "less" partition
        sortedList.add(pivot); // Add the pivot
        sortedList.addAll(quickSort(greater)); // Add sorted "greater" partition

        return sortedList;
    }

}
