package dsa;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayProblems {

    /**
     * Daily Coding Problem: Problem #1 [Easy]<br><br>
     * Array numbers add to k<br><br>
     * Given a list of numbers and a number k, return whether any two numbers
     * from the list add up to k.<br><br>
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.<br><br>
     * Bonus: Can you do this in one pass?<br><br>
     * @src This problem was recently asked by Google.<br><br>
     * @eval The given solution has a time complexity of O(n2) because it uses a nested loop to check all pairs of numbers in the array.
     *
     * @param array
     * @param k
     * @return
     */
    public Boolean addsToNumber(int[] array, int k){
        Boolean result = false;
        Boolean res = false;
        for (int i = array.length-1; i >= 0; i--){
            for (int j= i-1; j >=0; j-- ){
                int sum = array[i] + array[j];
                System.out.println("Matching "+ k +":  " + array[i] + " + " + array[j] + " = "  + sum);
                if(sum == k){
                    res = true;
                    System.out.println("Result: " + true  +"\n\r");
                } else {
                    System.out.println("Result: " + false +"\n\r");
                }
            }
        }
        return res;
    }

    /**
     * Daily Coding Problem: Problem #1 [Easy]<br><br>
     * A more efficient approach would be to use a hash set to keep track of the numbers we have seen so far.
     * This allows us to check if the complement (i.e., k−current_number) of the current number is already in the set,
     * which would mean there exists a pair that sums to k.<br>
     * @eval This solution has a time complexity of O(n).
     * @param array
     * @param k
     * @return
     */
    public Boolean addsToNumberByComplement(int[] array, int k){
        HashSet<Integer> seenNumbers = new HashSet<>();
        for(int num : array){
            int complement = k - num;
            if(seenNumbers.contains(complement)){
                return true;
            }
            seenNumbers.add(num);
        }
        return false;
    }

    /**
     * Given a positive integer n, find the smallest number of squared integers which sum to n.
     * For example, given n = 13, return 2 since 13 = 32 + 22 = 9 + 4.
     * Given n = 27, return 3 since 27 = 32 + 32 + 32 = 9 + 9 + 9.
     */
    public static int getSmallestSquaredIntComponent(int n) {
        // dp[i] will store the minimum number of squares that sum to 'i'
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 0; // 0 requires 0 squares

        // Fill dp array
        for (int i = 1; i <= n; i++) {
            int minSquares = i; // max squares is 'i' (1^2 + 1^2 + ... + 1^2)
            for (int j = 1; j * j <= i; j++) {
                minSquares = Math.min(minSquares, dp[i - j * j] + 1);
            }
            dp[i] = minSquares;
        }

        return dp[n];
    }

    /**
     * Two Sum<br><br>
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.<br><br>
     * @src: https://leetcode.com/problems/two-sum/solutions/
     * @param nums
     * @param target
     * @return
     * @status resolved
     * @eval
     * Space Complexity for HashMap Storage:<br>
     * In the worst case, where no two numbers add up to the target, the hash map will store all elements of the array.
     * This results in a space complexity of O(n).<br><br>
     * Time complexity:<br>
     * Iteration Over the Array:The method iterates through the array exactly once. This is an O(n) operation,
     * where  n is the number of elements in the array nums.<br>
     * Lookup Operation: The lookup operation seenNumbers.keySet().contains(complement) is O(1) on average.<br>
     * Insertion Operation: The insertion operation seenNumbers.put(nums[i], i) is also O(1) on average.
     */
    public static int[] getIndexOfTwoSumAsAddingToTarget(int[] nums, int target) {
        Map<Integer, Integer> seenNumbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(seenNumbers.keySet().contains(complement)){
                return new int[]{seenNumbers.get(complement), i};
            }
            seenNumbers.put(nums[i], i);
        }
        return new int[]{,};
    }

    /**
     * Get Multiples of Array Except for Array Index i<br><br>
     * Given an array of integers, return a new array such that each element at index
     * i of the new array is the product of all the numbers in the original array
     * except the one at i.<br>
     * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
     * If our input was [3, 2, 1], the expected output would be [2, 3, 6].<br><br>
     * Follow-up: what if you can't use division?<br>
     * @src This problem was asked by Uber. Daily Coding Problem: Problem #2 [Hard]
     * @eval The given solution for the problem has a time complexity of O(n2) due to the nested loops,
     * which makes it inefficient for large arrays
     * https://www.geeksforgeeks.org/a-product-array-puzzle/
     */
    public static  int[] getMultipesOfArrayExceptForArrayIndexI(int[] array){
        int n = array.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if( j != i){
                    result[i] *= array[j] ;
                }
            }
        }
        return result;
    }

    /**
     * Convenience Store<br><br>
     * Given a total due and an array representing the amount of change in your pocket,
     * determine whether or not you are able to pay for the item. Change will always be represented
     * in the following order: quarters, dimes, nickels, pennies.<br>
     * To illustrate: changeEnough([25, 20, 5, 0], 4.25) should yield true,
     * since having 25 quarters, 20 dimes, 5 nickels and 0 pennies gives you 6.25 + 2 + .25 + 0 = 8.50.<br><br>
     * quarter: 25 cents / $0.25<br>
     * dime: 10 cents / $0.10<br>
     * nickel: 5 cents / $0.05<br>
     * penny: 1 cent / $0.01<br>
     * @src https://edabit.com/challenge/jfquehNLzpXW5ZQu5
     * @eval The solution is efficient with both time and space complexities being O(1), making it highly suitable for
     * the given problem where the size of the coin array is fixed and small. T
     */
    public static boolean changeEnough(int[] array, double price){
        if(getTotalChange(array) >= price){
            return true;
        }
        return false;
    }
    /**
     * Convenience Store Helper
     */
    private static double getTotalChange(int[] array){
        double total = 0;
        double[] coinValues = {.25,.10,.05,.01};
        for(int i = 0; i < array.length; i++){
            total += array[i] * coinValues[i];
        }
        return total;
    }
    /**
     * Convenience Store Problem #2<br><br>
     * Determine whether the change you have can exactly match a give price by giving back the amount of each coin in
     * this order: quarters, dimes, nickels, pennies.<br>
     * @src Mathias Hamp
     * @param change array representing the number of each type of coin
     * @param price the total price to match
     * @return boolean indicating whether the exact change can be made
     */
    public static boolean hasExactChange(int[] change, double price){
        double[] coinValues = {.25,.10,.05,.01};
        Set<Double> possibleAmounts = new HashSet<>();
        for (int i = 0; i < change.length; i++ ){
            for(int j = 0; j <= change[i]; j++) {
                double coinValue = j * coinValues[i];
                if (coinValue == price) {
                    return true;
                }
                if (coinValue < price) {
                    possibleAmounts.add(coinValue);
                }
            }
        }
        List<Double> sortedAmounts = new ArrayList<>();
        possibleAmounts.stream()
                .sorted()
                .forEach(y -> sortedAmounts.add(y));

        for(int k = sortedAmounts.size() - 1; k >= 0; k--){
            double complement = price - sortedAmounts.get(k);
            if (possibleAmounts.contains(complement)){
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    /**
     * Revised version of Convenience Store Problem<br><br>
     *
     * @author ChatGPT
     * @eval Time Complexity: The time complexity is O(n * m) where n is the number of coin types (fixed at 4) and m
     * is the number of coins. The nested loops iterate over each coin and each possible amount,
     * making it manageable for small inputs.
     * Space Complexity: The space complexity is O(m) where m is the number of possible amounts of change,
     * which depends on the number of coins and their values.
     */
    public static boolean hasExactChangeImproved(int[] change, double price){
        double[] coinValues = {0.25, 0.10, 0.05, 0.01};
        Set<Double> possibleAmounts = new HashSet<>();
        possibleAmounts.add(0.0);
        for (int i = 0; i < change.length; i++) {
            Set<Double> newPossibleAmounts = new HashSet<>(possibleAmounts);
            for (int j = 1; j <= change[i]; j++) {
                double coinValue = j * coinValues[i];
                for (double amount : possibleAmounts) {
                    double newAmount = amount + coinValue;
                    if (newAmount == price) {
                        return true;
                    }
                    newPossibleAmounts.add(newAmount);
                }
            }
            possibleAmounts = newPossibleAmounts;
        }
        return possibleAmounts.contains(price);
    }


    /**
     * Difference of Max and Min Numbers in Array<br><br>
     * Create a function that takes an array and returns the difference between the biggest and smallest numbers.
     * @return
     * @eval To find the difference between the maximum and minimum numbers in the array, you can iterate through
     * the array once to find both the maximum and minimum values. This approach has a time complexity of O(n),
     * which is more efficient than sorting the array (O(n log n)).
     */
    public static int differenceMaxMin(int[] array){
        List<Integer> sortedArray = Arrays.stream(array)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        return sortedArray.get(sortedArray.get(0) - sortedArray.get(sortedArray.size() - 1));
    }

    /**
     * REVISED Difference of Max and Min Numbers in Array<br><br>
     * Create a function that takes an array and returns the difference between the biggest and smallest numbers.
     * @author ChatGPT
     * @param array input array of integers
     * @return difference between the maximum and minimum numbers in the array
     * @eval Time Complexity: O(n), where n is the number of elements in the array. The array is traversed only once.
     * Space Complexity: O(1), as we are using only a constant amount of extra space
     */
    public static int differenceMaxMinRevised(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min;
    }

    /**
     * Find a peak element which is not smaller than its neighbours<br>
     * Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing, find the maximum element in the array.
     * Note: If the array is increasing then just print the last element will be the maximum value.
     * @param arr
     * @param n
     * @return
     * @src <a href="https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/">Find a peak element which is not smaller than its neighbours</a>
     */
    static int findPeak(int arr[], int n){
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if( arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }


    /**
     * Array of Multiples
     * Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num until the array length reaches length.
     * @src <a href="https://edabit.com/challenge/rzpucPyoyEtXPo2BG">Array of Multiples</a>
     * @eval It has a time complexity of O(n), where n is the value of the length parameter,
     * as it needs to iterate length times to populate the array.
     */
    public static int[]arrayOfMultiples(int num, int length) {
        int[] array = new int[length];
        for(int i = 1; i <= length; i++){
            array[i - 1] = num * i;
        }
        return array;
    }

    /**
     * Write a Java function that takes an integer array as input and returns the sum of its maximum sum subarray.
     * A subarray is a contiguous part of the array. For example:
     * Input: arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * Output: 6 // (subarray: [4, -1, 2, 1])
     * Note: Try implementing it without any additional guidance to check your current skill level with arrays.
     *
     * @src ChatGPT
     */
    public int getMaxSumSubArray(int[] array){
        int max = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = i++; j < array.length; j++ ) {
                if (array[i] + array[j] > max) {
                    max += array[j];
                }
            }
        }
        return max;
    }

    /**
     * Given an array of integers, return a new array where each element in the new array
     * is the number of smaller elements to the right of that element in the original input array.
     *
     * For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:
     *
     * There is 1 smaller element to the right of 3
     * There is 1 smaller element to the right of 4
     * There are 2 smaller elements to the right of 9
     * There is 1 smaller element to the right of 6
     * There are no smaller elements to the right of 1
     * @src Daily Coding Problem: Problem #165 [Medium] by Google
     */
    public int[] getSmallerElementCountToTheRightWithBruteForce(int[] array){
        int[] result =  new int[array.length];
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for( int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    count++;
                }
            }
            result[i] = count;
            count = 0;
        }
        return result;
    }



}
