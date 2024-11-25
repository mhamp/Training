package dsa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathProblems {

    /**
     * Have the function MathChallenge(num) add up all the numbers from 1 to num. For example: if the input is 4 then
     * your program should return 10 because 1 + 2 + 3 + 4 = 10.<br>
     * For the test cases, the parameter num will be any number from 1 to 1000.
     *
     * @src coderbyte problem posed by SEG
     */
    public int MathChallenge(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        return result;
    }

    /**
     * using regex to identify the occurence of a minimum of two conscutive same numbers
     */
    public static void findConsecutiveNumbers(String inputString) {
        // __define-ocg__
        // Pattern to match consecutive same digits
        String regex = "(\\d)\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            String varOcg = matcher.group();  // Capture the matching group
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("Found match: %s, at positions: %d - %d%n", varOcg, start, end);
        }
    }

    /**
     * Write a function 'fib(n)' that takes in a number and an argument.
     * The function should return the n-th number of the Fibonacci sequence<br>
     */
    public Long getFibonacciNumber(Long n, Map<Long,Long> map) {
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        Long result =  getFibonacciNumber(n - 1,  map ) + getFibonacciNumber(n - 2, map);
        map.put(n,result);
        return map.get(n);
    }

    /**
     * Basic Calculator
     */
    public static long basicCalculator(long num1, long num2, String op){
        long result = 0;
        switch(op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zeor not allowed.");
                }
                result = num1 / num2;
                break;
            default: result = 0;

        }
        return result;
    }
    /**
     * Exists a Number Higher?<br><br>
     * Write a function that returns true if there exists at least one number that is larger than or equal to n.<br><br>
     * @src https://edabit.com/challenge/aWzxPLibBLJgn8AbZ
     */
    public boolean hasHigherNumberInArray(int[] arr, int n) {
        Arrays.sort(arr);
        int i = arr.length;
        return false;
    }

    /**
     * Fimmtudagstilboð<br><br>
     * Hafliði has been a regular at Mahjong Pizza’s Thursday-offer since its debut in 1993.
     * The offer consists of a single pizza with two toppings for ISK, that is until January 2021
     * when it increased by ISK and has done so every year since.<br>
     * Hafliði wants you to write a program that tells him how much the offer costs in the year given this pattern.<br><br>
     * Input: First and only line contains a single integer<br>
     * Output:  Write a single line containing the price of a Thursday-offer in the year<br>
     * @src <a href="https://open.kattis.com/problems/fimmtudagstilbod">Fimmtudagstilboð</a>
     */
    public static int getPizzaPriceByYear(int y){
        return y >= 1993 ?
                y-2020 > 0 ?
                        1000 + ((y-2020)*100) : 1000
                : 0;
    }

    /**
     * Write a function that calculates the salary depending on the occurence of certain words
     * in the job description.
     * @param input
     * @return
     */
    public static long evaluateSalary(String input){
        long salary = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("administer", 100000);
        map.put("spending ", 200000);
        map.put("manage ", 50000);
        map.put("responsibility ", 25000);
        map.put("expertise ", 100);
        map.put("skill ", 50);
        map.put("money ", 75000);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            Integer count = 1;
            count = countOccurrance(input, key);
            salary += value * count;
        }
        return salary;
    }

    /**
     * Salary Evaluation Helper
     */
    public static int countOccurrance(String input, String key){
        int count = 0;
        int fromIndex = 0;
        while((fromIndex = input.indexOf(key, fromIndex)) != -1){
            count++;
            fromIndex += key.length();
        }
        return count;
    }

    /**
     * Find the Discount<br><br>
     * Create a function that takes two arguments:<br>
     * the original price and the discount percentage as integers and returns the final price after the discount.
     * @param price
     * @param discount
     * @return
     * @eval Since all operations in the method are O(1), the overall time complexity is  O(1).
     * The method uses a few local variables (percent and the input parameters price and discount).
     * The space used by these variables does not depend on the size of the input but is instead fixed.
     * Therefore, the space complexity is also  O(1).
     */
    public static Double getDiscount(Integer price, Integer discount){
        if (price == null || discount == null) {
            throw new IllegalArgumentException("Price and discount cannot be null");
        }
        if (price < 0 || discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Price must be non-negative and discount must be between 0 and 100");
        }
        Double percent = discount / 100.0;
        return price * (1 - percent);
    }


    /**
     * Printing a Fibonacci Series
     * The Fibonacci sequence (series) is often one of the first Java assignments teaching recursion for beginners.
     * The basic Fibonacci algorithm is very simple, but works extremely slowly. This improves on that Fibonacci algorithm and generates Fibonacci numbers FAST.
     * We'll walk through the entire Fibonacci series algorithm step by step, and walk through coding the entire thing in Java.

     * https://www.youtube.com/watch?v=cum3OrpURzc
     */
    public static long getFibonacciAtN(int n){
        long result = 0;
        if(n <= 1) {
            return n;
        }
        return  (getFibonacciAtN(n - 1) + getFibonacciAtN(n - 2));
    }


    /**
     * Integer Digits Count
     * Create a function that counts the integer's number of digits.
     * https://edabit.com/challenge/4r33Yd2HuEireb3Sm
     */
    public static int countDigitsInInteger(int n) {
        if (n == 0) {
            return 1;
        }
        int counter = 0;
        int num = Math.abs(n);  // Handle negative numbers by converting to positive
        while(num > 0){
            num /= 10;
            counter++;
        }
        return counter;
    }

    /**
     * How Many Solutions Does This Quadratic Have?
     * A quadratic equation a x² + b x + c = 0 has either 0, 1, or 2 distinct solutions for real values of x.
     * Given a, b and c, you should return the number of solutions to the equation.
     * @src https://edabit.com/challenge/Rs23pTNpM6k5M2ThH
     * @note -b±√(b²-4ac))/(2a)
     * @note The number of solutions of a quadratic equation depends on the discriminant ( D), which is calculated as follows:
     * D=b * 2 −4ac
     * The number of solutions can be determined based on the value of D:
     * If D>0, there are 2 distinct real solutions.
     * If  D=0, there is 1 distinct real solution.
     * If  D<0, there are no real solutions.
     */
    public static int solutionForQuadraticFunction(int a, int b, int c) {
        int discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Solves the quadratic equation ax^2 + bx + c = 0 and returns the roots.
     * @param a Coefficient of x^2
     * @param b Coefficient of x
     * @param c Constant term
     * @return An array of doubles containing the roots of the quadratic equation.
     *         If there are no real roots, the array will be empty.
     *         If there is one real root, the array will contain one element.
     *         If there are two real roots, the array will contain two elements.
     */
    public static double[] solveQuadraticEquation(int a, int b, int c) {
        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // No real roots if the discriminant is negative
        if (discriminant < 0) {
            return new double[] {};
        }

        // One real root if the discriminant is zero
        if (discriminant == 0) {
            double root = -b / (2.0 * a);
            return new double[] { root };
        }

        // Two distinct real roots if the discriminant is positive
        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b + sqrtDiscriminant) / (2.0 * a);
        double root2 = (-b - sqrtDiscriminant) / (2.0 * a);
        return new double[] { root1, root2 };
    }


    /**
     * Quadratic Equation (Duplicate)
     * Create a function to find only the root value of x in any quadratic equation ax^2 + bx + c. The function will take three arguments:
     *
     * a as the coefficient of x^2
     * b as the coefficient of x
     * c as the constant term
     *
     * https://edabit.com/challenge/sBRPyEAjBfWKsnTaZ
     */
    public static int quadraticEquation(int a, int b, int c) {
        double discriminant = getDiscriminant(a,b,c);
        if(discriminant >= 0){
            return (int) ((-(b) + discriminant) / (2 * a));
        } else {
            return 0;
        }
    }
    /**
     * Quadratic Equation Helper
     */
    public static double getDiscriminant(int a, int b, int c){
        return Math.sqrt(b * b - (4 * a * c));
    }



    /**
     * FizzBuzz Interview Question<br><br>
     * Create a function that takes a number as an argument and returns "Fizz", "Buzz" or "FizzBuzz".
     * If the number is a multiple of 3 the output should be "Fizz".
     * If the number given is a multiple of 5, the output should be "Buzz".
     * If the number given is a multiple of both 3 and 5, the output should be "FizzBuzz".
     * If the number is not a multiple of either 3 or 5, the number should be output on its own as shown in the examples below.
     * The output should always be a string even if it is not a multiple of 3 or 5.
     * @src https://edabit.com/challenge/QCgoxbd32BqFr6AY7
     * @eval The time complexity of this function is O(1), or constant time.
     * The space complexity of the function is also O(1)
     */
    public static String fizzBuzz(int i){
        if(i % 3 == 0 && i % 5 == 0 ){
            return  "FizzBuzz";
        } else if(i % 5 ==0 ){
            return  "Buzz";
        } else if(i % 3 == 0 ){
            return  "Fizz";
        } else {
            return String.valueOf(i);
        }
    }


    /**
     * Equality of 3 Values
     * Create a function that takes three integer arguments (a, b, c) and returns the amount of integers which are of equal value.
     * @author Mathias Hamp
     * @src https://edabit.com/challenge/nfc7H9CQFqJp54uEh
     * @eval Implementation erroneous since if we have only i == j the counter would be incremented once whereas 2 should be returned
     */
    public static int equal(int i, int j, int k){
        int equals = 0;
        if(i == j){
            equals++;
        }
        if(i == k){
            equals++;
        }
        if(j == k){
            equals++;
        }
        return equals;
    }
    /**
     * Equality of 3 Values (Corrected)
     * Create a function that takes three integer arguments (a, b, c) and returns the number of integers that are of equal value.
     * @author ChatGPT
     * @eval Time Complexity: O(1). The function performs a constant number of comparisons regardless of the input values.
     * Space Complexity: O(1). The function uses a constant amount of space.
     */
    public static int equalRevised(int i, int j, int k) {
        if (i == j && j == k) {
            return 3; // All three are equal
        } else if (i == j || i == k || j == k) {
            return 2; // Exactly two are equal
        } else {
            return 0; // None are equal
        }
    }


    /**
     * The 3 Programmers Problem
     * You hired three programmers and you (hopefully) pay them. Create a function that takes three numbers
     * (the hourly wages of each programmer) and returns the difference between the highest-paid programmer and the lowest-paid.
     * @src https://edabit.com/challenge/akHQKSkHT26TuA7Ka
     * @eval Unnecessary Loop: The loop can be replaced with a simpler comparison logic.
     */
    public static int getProgrammersWages(int i , int j, int k){
        int min = i;
        int max = i;
        int[] wages = {i, j, k};
        for(int l = 0; l < wages.length; l++){
            if (wages[l] > max ){
                max = wages[l];
            }
            if( wages[l] < min ){
                min = wages[l];
            }

        }
        return max - min;
    }

    /**
     * The 3 Programmers Problem (REVISED
     * @author ChatGPT
     * @eval Time Complexity: O(1), because the number of operations is constant and does not depend on the size of the input.
     * Space Complexity: O(1), because no additional space is used that scales with input size.
     */
    public static int getProgrammersWagesRevised(int i , int j, int k){
        int min = Math.min(i, Math.min(j, k));
        int max = Math.max(i, Math.max(j, k));
        return max - min;
    }

    /**
     * Convert Minutes into Seconds
     * Write a function that takes an integer minutes and converts it to seconds.
     * @src <a href="https://edabit.com/challenge/2t8JDxF7wLrg7yJ5E">Convert Minutes into Seconds</a>
     */
    public static int toSeconds(int minutes){
        return minutes * 60;
    }

    /**
     * Any Prime Number in Range
     * Create a function that returns true if there's at least one prime number in the given range (n1 to n2 (inclusive)), false otherwise.
     * @src https://edabit.com/challenge/NjJ9gGNPGaQGxTxCc
     * @author Implementation by ChatGPT suggesting: The logic for checking prime numbers should break out of the inner loop as soon as a divisor is found.
     */
    public static boolean hasPrimeNumberInRange(int n1, int n2){
        for(int i = n1; i <= n2; i++){
            if(isPrime(i)){
                return true;
            }
        }
        return false;
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Find the Other Two Side Lengths<br><br>
     * Given the shortest side of a 30° by 60° by 90° triangle, find out the other two sides. Return the longest side and medium-length side in that order.<br><br>
     * Examples<br>
     * otherSides(1) ➞ [2.0, 1.73]<br>
     * otherSides(12) ➞ [24.0, 20.0]<br>
     * otherSides(2) ➞ [4.0, 3.46]<br>
     * otherSides(3) ➞ [6.0, 5.2]<br><br>
     * Notes<br>
     * 30° by 60° by 90° triangles always follow this rule: let's say the shortest side length is x units,
     * the hypotenuse would be 2x units and the other side would be x * square root of 3.<br>
     * The results in the Tests are rounded up to 2 decimal places.<br>
     * Return the result as an array.<br>
     * @src https://edabit.com/challenge/J26bZ6Fv6bWEisDYj
     */
    public static double[] getTriangleSideLengths(int n) {
        double[] result = new double[2];
        double hypotenuse = 2 * n;
        double catheter = n * Math.sqrt(3);

        BigDecimal hypotenuseAsBigDecimal = new BigDecimal(hypotenuse).setScale(2, RoundingMode.HALF_UP);
        BigDecimal catheterAsBigDecimal = new BigDecimal(catheter).setScale(2, RoundingMode.HALF_UP);
        result[0] = hypotenuseAsBigDecimal.doubleValue(); // Hypotenuse
        result[1] = catheterAsBigDecimal.doubleValue(); // Side opposite the 60° angle
        return result;
    }



    /**
     * Algorithms II: The Euclidean Algorithm
     * Welcome to part two of the collection for Computer Science Algorithms. This challenge will deal further with writing recursive functions by covering the Euclidean Algorithm. The "Euclidean Algorithm" is a method for finding the greatest common divisor (GCD) of two numbers. It was originally described by the Greek mathematician Euclid.
     *
     * Algorithm
     * For the sake of simplicity I'll refer to the first number as "a", the second number as "b", and the remainder as "r". The algorithm can be broken down into four steps:
     *
     * Ensure that "a" >= "b". If "a" < "b", swap them.
     * Find the remainder. Divide "a" by "b" and set "r" as the remainder.
     * Is "r" zero? If so terminate the function and return "b" (the second number).
     * Set "a" = "b" and "b" = "r" and start the algorithm over again.
     * Instructions
     * Create a recursive function that returns the GCD between two positive numbers using the Euclidean Algorithm.
     * https://edabit.com/challenge/HmicQW4LMYyNHXRzT
     */
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    /**
     * Odd/Even Check of random number
     * Generate an array with an amount n of random numbers in range between min and max and
     * evaluate each number whether it is odd or even
     * @src &1 Interview Question
     */
    public static void populateWithRandomNumbersForGivenAmount(int amount, int min, int max){
        int[] array = new int[amount];
        for(int i = 0; i < amount - 1; i++){
            array[i] = generateRandomNumberInGivenRange(min, max);
        }
        for(int j = 0; j < array.length; j++){
            System.out.println(  j + 1 +". The Number is: " + array[j] + ". The number is even: " + evenOddCheck(array[j]));
        }
    }

    /**
     * Odd/Even Check of random number Helper
     */
    public static int generateRandomNumberInGivenRange(int min, int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Odd/Even Check of random number Helper
     */
    public static boolean evenOddCheck(int i){
        return i % 2 == 0 ? true : false;
    }


    /**
     * Upvotes vs Downvotes
     * Given an object containing counts of both upvotes and downvotes, return what vote count should be displayed.
     * This is calculated by subtracting the number of downvotes from upvotes.
     * @src <a href="https://edabit.com/challenge/XJxu5LCnqN9K8SXm5">Upvotes vs Downvotes</a>
     */
    public static int getVoteCount(int upvotes, int downvotes){
        return upvotes - downvotes;
    }


    /**
     * Write a Java program that takes a positive integer n and outputs the sum of all even numbers from 1 to n.
     * @src ChatGPT
     */
    public int getSumOfAllEvensToN(int n){
        int sum = 0;
        for(int i = 0; i <= n; i = i + 2){
            sum += i;
        }
        return sum;
    }

    /**
    * Given a 32-bit integer, return the number with its bits reversed.
    * For example, given the binary number 1111 0000 1111 0000 1111 0000 1111 0000,
    * return 0000 1111 0000 1111 0000 1111 0000 1111.
    *
    * @src Daily Coding Problem: Problem #161 [Easy] Facebook
    */
    public static int getReversedInteger(int num){
        return num >> num +1;
    }


}
