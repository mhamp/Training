package dsa;

import java.util.*;

public class SearchingAlgorithms {

    /**
     * Lowest Positive Number <br><br>
     * Given an array of integers, find the first missing positive integer in linear time and constant space.
     * In other words, find the lowest positive integer that does not exist in the array. The array can contain
     * duplicates and negative numbers as well.<br><br>
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     * @src This problem was asked by Stripe.
     */
    public static int getLowestPositiveNumber(int[] array){
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        for(int i : set){
            boolean searching = true;
            while(searching){
                for(int j = 1; j < 100; j++){
                    if(set.contains(j)) {
                        continue;
                    } else {
                        return j;
                    }
                }
            }
        }
        return result;
    }

    /**
     * We can avoid using nested loops by iteratively checking for the lowest positive number in a single loop.
     * Instead of searching through a fixed range in each iteration,
     * we can use a variable to track the current candidate for the lowest positive number and check its presence in the set.
     * Instead of storing positive numbers in a HashSet, we can utilize a boolean array or an alternative approach to efficiently track the presence of numbers.
     * This revised method provides an efficient and concise solution to find the lowest positive number not present in the input array.
     * @ eval Time Complexity: O(n) due to single pass and lookups, Space Complexity:  O(n) for the boolean array.
     * @param array
     * @return
     */
    public static int getLowestPositiveNumberRevised(int[] array) {
        boolean[] presence = new boolean[array.length + 2]; // Initialize a boolean array to track presence
        for (int num : array) {
            if (num > 0 && num <= array.length + 1) { // Check for valid positive numbers
                presence[num] = true; // Mark presence
            }
        }
        for (int i = 1; i <= array.length + 1; i++) { // Check for the lowest positive number
            if (!presence[i]) {
                return i; // Return the first missing positive number
            }
        }
        return -1; // If all positive numbers up to array.length + 1 are present
    }

    public static void getSortedArray(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static int reverseInteger(int i){
        int reversed = 0;
        while(i != 0){
            int digit = i % 10;
            i /= 10;
            // Check for overflow
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow condition: public static final int MAX_VALUE = 2147483647
            }
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow condition: public static final int MIN_VALUE = -2147483648
            }
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }


    /**
     * Eb Alto Saxophone Player<br><br>
     * Do you like saxophone? I have an Eb Alto Saxophone, shown to the right.
     * My fingers move a lot when playing some music, and I’m quite interested in how many times each finger presses a button.
     * Assume that the music is composed of only  14 different notes. They are: <br>
     * C D E F G A B in one octave and C D E F G A B in a higher octave.
     * We use c,d,e,f,g,a,b,C,D,E,F,G,A,B to represent them. The fingers I use for each note are:<br><br>
     *
     * c: finger 2-4, 7-10<br>
     * d: finger 2-4, 7-9<br>
     * e: finger 2-4, 7,8<br>
     * f: finger 2-4, 7<br>
     * g: finger 2-4<br>
     * a: finger 2-3<br>
     * b: finger 2<br>
     * C: finger 3<br>
     * D: finger 1-4, 7-9<br>
     * E: finger 1-4, 7,8<br>
     * F: finger 1-4, 5<br>
     * G: finger 1-4<br>
     * A: finger 1-3<br>
     * B: finger 1-2<br><br>
     *
     * Write a program to help count the number of times each finger presses the button.
     * A finger presses a button if it is needed in a note, but not used in the last note.
     * Also, if it is the first note, every finger required presses a button.<br><br>
     *
     * Input<br>
     * The first line of the input is a single integer t (1 <= t <=1000), indicating the number of test cases.
     * For each case, there is only one line containing the song. The only allowed characters are “cdefgabCDEFGAB”.
     * There are at most  notes in a song, and the song maybe empty.<br><br>
     *
     * Output<br>
     * For each test case, print numbers indicating the number of presses for each finger. Numbers are separated by a single space.<br><br>
     *
     * @src <a href="https://open.kattis.com/problems/saxophone?editresubmit=13802586">Eb Alto Saxophone Player</a>
     * @author Mathias hamp
     * @status This solution has an erroneous counter.
     */
    public static List<List<Integer>> getKeyStats(List<String> songs){
        List<List<Integer>> result = new ArrayList<>();
        for(String song : songs){
            if (song.length() > 200){
                throw new IllegalArgumentException("Songs hava a max length <= 200.");
            }
        }

        Map<Integer, Map<String, Integer>> keyStats = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("pressed", 0);
            map.put("released", 0);
            map.put("counter", 0);
            keyStats.put(i, map);
        }

        Map<String, List<Integer>> keys = new HashMap<>();
        keys.put("c", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,9,10)));
        keys.put("d", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,9,0)));
        keys.put("e", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,0,0)));
        keys.put("f", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,0,0,0)));
        keys.put("g", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,0,0,0,0)));
        keys.put("a", new ArrayList<Integer>(Arrays.asList(0,2,3,0,0,0,0,0,0,0)));
        keys.put("b", new ArrayList<Integer>(Arrays.asList(0,2,0,0,0,0,0,0,0,0)));
        keys.put("C", new ArrayList<Integer>(Arrays.asList(0,0,3,0,0,0,0,0,0,0)));
        keys.put("D", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,8,9,0)));
        keys.put("E", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,8,0,0)));
        keys.put("F", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,0,0,0)));
        keys.put("G", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,0,0,0,0)));
        keys.put("A", new ArrayList<Integer>(Arrays.asList(1,2,3,0,0,0,0,0,0,0)));
        keys.put("B", new ArrayList<Integer>(Arrays.asList(1,2,0,0,0,0,0,0,0,0)));

        for(String song : songs){
            for(char c : song.toCharArray()){
                String key = String.valueOf(c);
                if (keys.containsKey(key)) { // Check if the map contains the key
                    List<Integer> values = keys.get(key);
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i) != 0 && keyStats.get(i + 1).get("pressed") == 0) {
                            keyStats.get(i + 1).put("pressed", 1);
                        }
                        if (values.get(i) == 0 && keyStats.get(i + 1).get("pressed") == 1) {
                            keyStats.get(i + 1).put("pressed", 0);
                            keyStats.get(i + 1).put("counter", keyStats.get(i + 1).get("counter") + 1);
                        }
                    }
                } else {
                    System.out.println("Key not found: " + key);
                }
            }
            List<Integer> keyPressedBySong = new ArrayList<>();
            for (int i = 0; i < 10;i++){
                keyPressedBySong.add(keyStats.get(i + 1).get("counter"));
                keyStats.get(i + 1).put("pressed", 0);
                keyStats.get(i + 1).put("released", 0);
                keyStats.get(i + 1).put("counter", 0);
            }
            result.add(keyPressedBySong);
        }
        return result;
    }

    /**
     * Using set and comparing the presence of key in sets is more efficient. Besides the data structure with that
     * map keystats instead of a simple int[] is far more elegant and comprehensive.
     *
     * @author ChatGPT
     * @eval Putting it all together, for each song, we perform operations that are bounded by O(n) where n
     * is the length of the song. Since we have t songs, the overall time complexity is O(t×n).
     * Overall, the space complexity is dominated by the space required to store the results, which is  O(t).
     */
    public static List<List<Integer>> getKeyStatsRevised(List<String> songs) {
        List<List<Integer>> result = new ArrayList<>();

        // Define the mapping from notes to finger presses
        Map<String, Set<Integer>> keys = new HashMap<>();
        keys.put("c", new HashSet<>(Arrays.asList(2, 3, 4, 7, 8, 9, 10)));
        keys.put("d", new HashSet<>(Arrays.asList(2, 3, 4, 7, 8, 9)));
        keys.put("e", new HashSet<>(Arrays.asList(2, 3, 4, 7, 8)));
        keys.put("f", new HashSet<>(Arrays.asList(2, 3, 4, 7)));
        keys.put("g", new HashSet<>(Arrays.asList(2, 3, 4)));
        keys.put("a", new HashSet<>(Arrays.asList(2, 3)));
        keys.put("b", new HashSet<>(Collections.singletonList(2)));
        keys.put("C", new HashSet<>(Collections.singletonList(3)));
        keys.put("D", new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9)));
        keys.put("E", new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        keys.put("F", new HashSet<>(Arrays.asList(1, 2, 3, 4, 7)));
        keys.put("G", new HashSet<>(Arrays.asList(1, 2, 3, 4)));
        keys.put("A", new HashSet<>(Arrays.asList(1, 2, 3)));
        keys.put("B", new HashSet<>(Arrays.asList(1, 2)));

        for (String song : songs) {
            if (song.length() > 200) {
                throw new IllegalArgumentException("Songs have a max length <= 200.");
            }

            // Reset keyStats for each song
            int[] keyStats = new int[10];

            // Keep track of previously pressed fingers
            Set<Integer> previousPressedFingers = new HashSet<>();

            for (char c : song.toCharArray()) {
                String key = String.valueOf(c);
                Set<Integer> currentPressedFingers = keys.getOrDefault(key, new HashSet<>());

                // Count presses for fingers that are now pressed but weren't pressed before
                for (int finger = 1; finger <= 10; finger++) {
                    if (currentPressedFingers.contains(finger) && !previousPressedFingers.contains(finger)) {
                        keyStats[finger - 1]++;
                    }
                }

                // Update previous pressed fingers
                previousPressedFingers = currentPressedFingers;
            }

            List<Integer> keyPressedBySong = new ArrayList<>();
            for (int count : keyStats) {
                keyPressedBySong.add(count);
            }
            result.add(keyPressedBySong);
        }

        return result;
    }


    /**
     * Xs and Os, Nobody Knows<br><br>
     * Create a function that takes a string, checks if it has the same number of x's and o's and returns either true or false.<br>
     *
     * Rules<br><br>
     * Return a boolean value (true or false).<br>
     * Return true if the amount of x's and o's are the same.<br>
     * Return false if they aren't the same amount.<br>
     * The string can contain any character.<br>
     * When "x" and "o" are not in the string, return true.<br>
     * @src <a href="https://edabit.com/challenge/bkFqwEP5Gej23didA">Xs and Os, Nobody Knows</a>
     * @eval The method operates in linear time O(n) with constant space  O(1), making it efficient for typical use cases.
     */
    public static boolean getXO(String str){
        int counterX = 0;
        int counterO = 0;
        for (char c : str.toCharArray()) {
            c = Character.toLowerCase(c);
            if (c == 'x') {
                counterX++;
            } else if (c == 'o') {
                counterO++;
            }
        }
        return counterX == counterO;
    }


    /**
     * Count Letters in a Word Search
     * Create a function that counts the number of times a particular letter shows up in the word search.
     */
    public static int letterIn2DArrayCounter(char[][] arr, char c) {
        int counter = 0;
        for (int i= 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == c){
                    counter++;
                }
            }
        }
        return counter;
    }


    /**
     * War of Numbers<br><br>
     * There's a great war between the even and odd numbers. Many numbers already lost their lives in this war and
     * it's your task to end this. You have to determine which group sums larger: the evens, or the odds. The larger group wins.<br>
     * Create a function that takes an array of integers, sums the even and odd numbers separately,
     * then returns the difference between the sum of the even and odd numbers.<br>
     * @src https://edabit.com/challenge/7fHsizQrTLXsPWMyH
     * @eval While the current implementation is correct and straightforward,
     * the difference calculation can be simplified using Math.abs to directly return the absolute difference.
     * This eliminates the need for the conditional statement.
     */
    public static int warOfNumbers(int[]numbers){
        int evensSum = 0;
        int oddsSum = 0;
        for (int i : numbers){
            if (i % 2 == 0){
                evensSum += i;
            } else {
                oddsSum += i;
            }
        }
//        if (evensSum > oddsSum){
//            return evensSum - oddsSum;
//        } else {
//            return oddsSum - evensSum;
//        }
        return Math.abs(evensSum - oddsSum);
    }

    /**
     * Autocomplete<br><br>
     * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
     * return all strings in the set that have s as a prefix.<br>
     * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].<br>
     * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
     *
     * @src This problem was asked by Twitter. Daily Coding Problem: Problem #11 [Medium]
     * @eval The current implementation has a time complexity of O(n⋅m), where  n is the number of strings in the list and
     * m is the length of the pattern. This is because for each string, a substring operation and a comparison are performed.
     */
    public static List<String> autocompleteByPattern(List<String> strList, String pattern){
        List<String> result = new ArrayList<>();
        int patternLength = pattern.length();
        for (String str : strList){
            if(str.length() >= patternLength && str.substring(0, patternLength).equalsIgnoreCase(pattern)){
                result.add(str);
            }
        }
        return result;
    }

    /**
     * Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).
     *
     * You can assume that such element exists.
     * For example, given [1, 2, 1, 1, 3, 4, 0], return 1.
     * @src Daily Coding Problem: Problem #155 [Medium]
     */
    public static void getMajorityElement(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int majorityCount = arr.length / 2;
        int majorityElement = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityCount) {
                majorityElement = entry.getKey();
                break; // We can break since we know there's a guaranteed majority element
            }
        }
        System.out.println("The majority element is: " + majorityElement);
    }

    /**
     * Given a list of words, return the shortest unique prefix of each word.
     * For example, given the list:
     * dog -> d
     * cat -> c
     * apple -> app
     * apricot -> apr
     * fish -> f
     * @src Daily Coding Problem #162 [Medium] Square
     */
    public static Map<String, String> getUniquePrefix(List<String> words){
        Map<String, String> wordToPrefix = new HashMap<>();
        Set<String> uniquePrefixes = new HashSet<>();
        for (String word : words) {
            int chars = 1; // Start with a prefix length of 1
            String prefix = word.substring(0, chars);
            while (uniquePrefixes.contains(prefix) && chars < word.length()) {  // Increment prefix length until it's unique
                chars++;
                prefix = word.substring(0, chars);
            }
            uniquePrefixes.add(prefix); // Add the unique prefix to sets
            wordToPrefix.put(word, prefix);
        }
        return wordToPrefix;
    }
}
