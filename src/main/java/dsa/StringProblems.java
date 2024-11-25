package dsa;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProblems {
    /**
     * Get Word Count<br><br>
     * Create a method that takes a string and returns the word count.
     * The string will be a sentence.<br><br>
     * @src <a href="https://edabit.com/challenge/5LnycSd2xT4uwZCpi">...</a>
     * @solution This analysis shows that the function is linear in both time and space relative to the size of the input string.
     * This efficiency is appropriate for typical use cases involving string manipulation in Java.
     */
    public int getWordCount(String str){
        char[] chars = str.toCharArray();
        int wordCounter = 0;
        int charsCount = 0;
        for (char c : chars){
            if( c != ' '){
                charsCount++;
                if(charsCount == 1){
                    wordCounter++;
                }
            } else {
                charsCount = 0;
            }
        }
        return wordCounter;
    }

    /**
     * Get Word Count<br><br>
     * Create a method that takes a string and returns the word count.
     * The string will be a sentence.<br><br>
     * @src <a href="https://edabit.com/challenge/5LnycSd2xT4uwZCpi">...</a>
     * @solution This analysis shows that the function is linear in both time and space relative to the size of the input string.
     * This efficiency is appropriate for typical use cases involving string manipulation in Java.
     */
    public static int getWordCountImproved(String str){
        return str.trim().split("\\s+").length;
    }
    /**
     * Check if String Ending Matches Second String<br><br>
     * Create a function that takes two strings and returns true
     * if the first string ends with the second string; otherwise return false.
     * @src https://edabit.com/challenge/PZnwXraqBPYv7w4Sm
     */
    public boolean checkStringEnd(String str1, String str2) {
        boolean result = false;
        char[] str1AsCharArray = str1.toCharArray();
        char[] str2AsCharArray = str2.toCharArray();
        int counterStr2 = 0;
        for(int i = str2AsCharArray.length - 1; i >= 0; i--){
            if (str1AsCharArray[(str1AsCharArray.length -1 ) - counterStr2] == str2AsCharArray[i]){
                result = true;
            } else {
                result = false;
            }
            counterStr2++;
        }
        return result;
    }
    /**
     * Optimized Check if String Ending Matches Second String<br><br>
     * An optimized version of the function without converting the strings to character arrays can reduce space complexity to  O(1):
     * @src https://chatgpt.com/c/6f71c809-535f-4c07-9e42-6092b5f52ef7
     */
    public boolean checkEndOptimized(String str1, String str2) {
        // If str1 is shorter than str2, it cannot end with str2
        if (str1.length() < str2.length()) {
            return false;
        }
        // Compare characters from the end of str1 with characters from str2
        int str1Index = str1.length() - str2.length();
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(str1Index + i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Have the function CountingAnagrams(str) take the str
     * parameter and determine how many anagrams exist in the string. An anagram is a new word that is produced from
     * rearranging the characters in a different word, for example: cars and arcs are anagrams.<br>
     * Your program should determine how many anagrams exist in a given string and return the total number.<br>
     * For example: if str is "aa aa odg dog gdo" then your program should return 2 because "dog" and "gdo" are anagrams of "odg". The word "aa" occurs twice in the string but it isn't an anagram because it is the same word just repeated.
     * The string will contain only spaces and lowercase letters, no punctuation, numbers, or uppercase letters.<br>
     */
    public static String SortString(String inputString){
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public static int CountingAnagrams(String str) {

        Set<String> setOfWords = new HashSet<>(Arrays.asList(str.split(" ")));
        Set<String> setOfBasicWords = new HashSet<>();
        setOfWords.forEach(word -> setOfBasicWords.add(SortString(word)));

        return setOfWords.size() - setOfBasicWords.size();

    }

    /**
     * Have the function StringChallenge(strArr) read the array of strings stored in strArr,
     * which will contain two elements, the first some sort of string and the second element will be a number
     * ranging from 1 to 6. The number represents how many rows to print the string on so that it forms a zig-zag pattern.<br>
     * For example: if strArr is ["coderbyte", "3"] then this word will look like the following
     * if you print it in a zig-zag pattern with 3 rows:<br><br>
     *
     * Your program should return the word formed by combining the characters as you iterate through each row,
     * so for this example your program should return the string creoebtdy.
     */
    public static String StringChallenge(String[] strArr) {
        String word = strArr[0];
        int numRows = Integer.parseInt(strArr[1]);

        if (numRows == 1) return word;

        StringBuilder[] varOcg = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            varOcg[i] = new StringBuilder();
        }

        int index = 0;
        boolean goingDown = true;

        for (char c : word.toCharArray()) {
            varOcg[index].append(c);
            if (index == 0) {
                goingDown = true;
            } else if (index == numRows - 1) {
                goingDown = false;
            }
            index += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : varOcg) {
            result.append(row);
        }

        return result.toString();
    }

    /**
     * Serial Number Validation
     * Have the function StringChallenge(str) take the str parameter being passed and determine if it is
     * a valid serial number with the following constraints<br>
     *
     * 1. It needs to contain three sets each with three digits (1 through 9) separated by a period.<br>
     * 2. The first set of digits must add up to an even number.<br>
     * 3. The second set of digits must add up to an odd number.<br>
     * 4. The last digit in each set must be larger than the two previous digits in the same set.<br>
     *
     * If all the above constraints are met within the string, the your program should return the string true,
     * otherwise your program should return the string false.<br>
     * For example: if str is "224.315.218" then your program should return "true".
     */
    public String SerialNumberStringChallenge(String input){
        if (isFormatRight(input)){
            String[] parts = input.split("\\.");;
            int[] firstDigits = getDigits(parts[0]);
            int[] secondDigits = getDigits(parts[1]);
            if(isFirstOddAndSecondEven(firstDigits, secondDigits)){
                int[] thirdDigits = getDigits(parts[2]);
                if (isLastSetDigitLargerThanFirstTwo(firstDigits, secondDigits, thirdDigits)){
                    return "true";
                }
            }
        }
        return "false";
    }

    public boolean isLastSetDigitLargerThanFirstTwo(int[] firstDigits, int[] secondDigits, int[] thirdDigits){
        // __define-ocg__: Check if the last digit is larger than the first two in each set
        if(firstDigits[2] > firstDigits[0] && firstDigits[2] > firstDigits[1]){
            if(secondDigits[2] > secondDigits[0] && secondDigits[2] > secondDigits[1]){
                if(thirdDigits[2] > thirdDigits[0] && thirdDigits[2] > thirdDigits[1]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFirstOddAndSecondEven(int[] firstDigits, int[] secondDigits){
        // __define-ocg__: Check if the first set adds to an even number and the second set to an odd number
        int firstDigitsSum = addDigits(firstDigits);
        int secondDigitsSum = addDigits(secondDigits);
        if(isEven(firstDigitsSum) && !isEven(secondDigitsSum)){
            return true;
        }
        return false;
    }

    public boolean isFormatRight(String str){
        // __define-ocg__: Check if the string is in the correct format
        String regex = "(\\d{3}\\.){2}\\d{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public int addDigits(int[] digits){
        // Sum all digits in the array
        int result = 0;
        for(int digit : digits){
            result += digit;
        }
        return result;
    }

    public boolean isEven(int i){
        // Check if a number is even
        return i % 2 == 0;
    }

    public  int[] getDigits(String str){
        // Convert a string to an array of integers representing the digits
        int length = str.length();
        int[] digits = new int[length];
        for(int i = 0; i < length; i++){
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }

    /**
     * Shuffle the Name<br><br>
     * Create a method that accepts a string (of a person's first and last name)
     * and returns a string with the first and last name swapped.<br>
     * @src https://edabit.com/challenge/8WBpaPzLP7piuHNeR
     * @eval Time Complexity: The time complexity of the method is O(n), where
     * n is the length of the input string. This is because both the trim and split operations run
     * in linear time relative to the length of the input string.
     * Space Complexity: The space complexity is also O(n) due to the storage required for the split array and the result string.
     */
    public static String reverseTwoWordString(String str){
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        String[] array = str.trim().split("\\s+");
        if (array.length != 2) {
            throw new IllegalArgumentException("Input string must contain exactly two words");
        }
        return array[1] +" "+ array[0];
    }

    /**
     * Stuttering Function<br><br>
     * Write a function that stutters a word as if someone is struggling to read it. The first two letters are repeated
     * twice with an ellipsis ... and space after each, and then the word is pronounced with a question mark ?.<br><br>
     *
     * @eval Time Complexity: O(n). Substring operations and StringBuilder append operations are linear
     * with respect to the length of the input string.
     * Sapce Complexity: O(n): The space used by StringBuilder is proportional to the length of the input string
     * and the resultant string.
     */
    public static String stutterWord(String str){
        StringBuilder stb = new StringBuilder("\"");
        String st;
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        if (str.length() > 3 ){
            st = str.substring(0,2);
        } else {
            st = str.substring(0, 1);
        }
        for(int i = 0; i < 2; i ++ ) {
            stb = stb.append(st).append("... ");
        }
        stb.append(str + "?\"");
        return stb.toString();
    }


    /**
     * Adding Numbers
     * Create a function that takes two number strings and returns their sum as a string.
     *
     * @src https://edabit.com/challenge/vFLhYANAZQGKTtxA2
     * @author ChatGPT The method does not handle potential exceptions that might occur if the input strings are not valid integer representations.
     * The method uses Integer.valueOf which may lead to an IntegerOverflowException for large numbers. Using Long.valueOf or BigInteger would be more robust for very large inputs.
     *
     */
    public static String addToStringAsNumbersAndReturnAsString(String a, String b) {
//        int num1 = Integer.valueOf(a);
//        int num2 = Integer.valueOf(b);
//        return String.valueOf(num1 + num2);
        try {
            BigInteger num1 = new BigInteger(a);
            BigInteger num2 = new BigInteger(b);
            return num1.add(num2).toString();
        } catch (NumberFormatException e) {
            return "Invalid input";
        }
    }



    /**
     * Reverse Order of a String
     * Create a method that takes a string as its argument and returns the string in reversed order.
     * @src https://edabit.com/challenge/5gPCp7v7iDWZvb4YQ
     * @author Mathias Hamp
     */
    public static String reverseString(String str){
        int length = str.length();
        StringBuilder stb = new StringBuilder();
        for (int i = length - 1; i >= 0; i-- ){
            stb.append(str.charAt(i));
        }
        return stb.toString();
    }

    /**
     * Reverse Order of a String (IMPROVED)
     * Create a method that takes a string as its argument and returns the string in reversed order.
     * @author ChatGPT
     * @eval Time Complexity: O(n), where n is the length of the string. This is because reversing the string
     * involves a single pass through the characters.
     * Space Complexity: O(n), as a new StringBuilder of the same length as the input string is created.
     */
    public static String reverseStringImproved(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Re-Form the Word
     * A word has been split into a left part and a right part. Re-form the word by adding both halves together,
     * changing the first character to an uppercase letter.
     * @src https://edabit.com/challenge/R3PnRquBPADEqDxZg
     * @eval The method currently capitalizes the entire first string (str1.toUpperCase()) instead of just the first character.
     */
    public static String getWord(String str1, String str2){
        String combined = str1 + str2;
        return combined.substring(0,1).toUpperCase() + combined.substring(1);
    }

    /**
     * Phone Number Formatting
     * Create a method that takes an array of 10 integers (between 0 and 9) and returns a string of those numbers formatted as a phone number (e.g. (555) 555-5555).
     * @src https://edabit.com/challenge/sPz2LcPZyAiBHRgwX
     */
    public static String formatPhoneNumbers(int[] i){
        if(i.length != 10){
            throw new IllegalArgumentException("The amount of digits should be 10.");
        }
        if(isSingleDigitArray(i)){
            throw new IllegalArgumentException("The digits be single digits.");
        }

        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("("+i[0] + i[1] + i[2]+") " + i[3] + i[4] + i[5] + "-" + i[6] + i[7] + i[8] + i[9]);
        return phoneNumber.toString();
    }
    /**
     * Phone Number Formatting Helper
     */
    public static boolean isSingleDigitArray(int[] i){
        for(int j : i){
            if(j < 0 && j > 9) {
                return false;
            }
        }
        return true;
    }



    /**
     * How Many Vowels?
     * Create a function that takes a string and returns the number (count) of vowels contained within it.
     * @src https://edabit.com/challenge/GBKphScsmDi9ek3ra
     * @eval Time complexity  O(n * m), where n is the length of the string and m is the number of vowels (which is a constant 5 in this case).
     */
    public static int countVowels(String str){
        int counter = 0;
        char[] vowels = new char[]{'a','e','i','o','u'};
        char[] chars = str.toCharArray();
        for(char c : chars){
            for(char v : vowels){
                if(c == v){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * How Many Vowels? (REVISED)
     * Create a function that takes a string and returns the number (count) of vowels contained within it.
     * @author ChatGPT
     * @eval Using a Set for vowel look-up reduces the inner loop to O(1), resulting in an overall time complexity of O(n), where n is the length of the string.
     * Time Complexity: O(n), where n is the length of the input string. This is due to the single iteration through the string with O(1) look-ups in the Set.
     * Space Complexity: O(1) additional space for the Set of vowels, as its size does not scale with the input string length.
     */
    public static int countVowelsRevised(String str) {
        int counter = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        for (char c : str.toCharArray()) {
            if (vowels.contains(c)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Given a string, determine whether any permutation of it is a palindrome.
     *
     * For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome.
     * daily should return false, since there's no rearrangement that can form a palindrome.
     */
    public boolean isPalindrome(String str){
        Map<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check how many characters have an odd count
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // A palindrome permutation can have at most one odd character count
        return oddCount <= 1;
    }

    /**
     * Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.
     *
     * For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
     * return 1 because there's only one word "cat" in between the two words.
     */
    public static int getShortedDistanceBetweenTwoWords(String sentence, String str1, String str2){
        if(sentence.isEmpty() || str1.isEmpty() || str2.isEmpty() ||
        !sentence.contains(str1) || !sentence.contains(str2)){
            throw new IllegalArgumentException("Strings can't be null. Sentence must contain searched strings.");
        }
        String[] array = sentence.split("\\w+");
        Map<Integer, String> map = new HashMap<>() ;
        Set<Integer> positions = new HashSet<>();
        int distance = 0;
        // populate the map with all string elements
        for (int i = 1; i < array.length; i++){
            map.put(i, array[i]);
        }
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            if(entry.getValue().equals(str1) || entry.getValue().equals(str2)){
                positions.add(entry.getKey());
            }
        }
        OptionalInt minSubtraction =  positions.stream()
                .flatMapToInt(x -> positions.stream().mapToInt(y -> x - y))
                .filter(result -> result >= 0) // If only non-negative results are needed
                .min();

        return distance;
    }
}
