package dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixProblems {

    /**
     * River Sizes<br>
     * You're given a two-dimenaional array (a matrix of potentially
     * unequal height and width containing only 0s and 1s. Each
     * 0 represents land, and each 1 represents part of a river. A
     * river consits of any number of 1s taht are either
     * horizontaly and vertically adjacent ( but not diagonally adjactent).
     * The number of adjactent 1s forming a river its size.<br><br>
     * Note that a river can twist. In other words, it doesn't have to
     * be a straingth vertical line or a straight horizontal like; it can be
     * L-shaped, for example.<br><br>
     * Write a function that returns an array of the sizes of all rivers
     * represented in the ininput matrix. The dizes don't need to in any
     * particular order.<br>
     *
     * @src <a href="https://www.algoexpert.io/questions/river-sizes">...</a>
     * @return int[]
     * @status unresolved
     */
    public static int[] getRiverSizes(int[][] matrix){
        List<Integer> riverInts = new ArrayList<>();
        int riverLengthHorizontal = 0;
        Set<Integer> riverSizes = new HashSet<>();
        System.out.println("Matrix rows: " + matrix.length);
        System.out.println("Matrix cols: " + matrix[0].length);
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 0) {
                    continue;
                } else if (j == 0 && matrix[i][j] == 1){
                    riverLengthHorizontal = 1;
                } else {
                    if (matrix[i][j] == 1 && matrix[i][j - 1] == 1){
                        riverLengthHorizontal++;
                    }
                }
            }
            riverSizes.add(riverLengthHorizontal);
            System.out.println(" ");
        }
        System.out.println("Amount of Ones in matrix: " + riverInts.size());
        System.out.print("Horizontal river length check: " );
        riverSizes.stream().forEach( x ->{ System.out.print(x + ", ");});
        return riverSizes.stream().mapToInt(i -> i).toArray();
    }

    /**
     * RiverSizes Solution by Igor Bertan<br>
     * @eval Time Complexity: O(m×n), Space Complexity: O(m×n)
     */
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> lengths = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 1) {
                    continue;
                } else {
                    lengths.add(0);
                    checkNode(i, j, lengths, matrix);
                }
            }
        }
        return lengths;
    }

    /**
     * CheckRiverSize Utility
     */
    static void checkNode(int i, int j, List<Integer> lengths, int[][] matrix) {
        matrix[i][j] = -lengths.size();  // Mark the current cell as visited by setting it to a negative value (to avoid revisiting)
        int lastIndex = lengths.size() - 1;
        lengths.set(lastIndex, lengths.get(lastIndex) + 1);  // Increment the size of the current river

        if (i > 0 && matrix[i - 1][j] == 1) {
            checkNode(i - 1, j, lengths, matrix);
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
            checkNode(i + 1, j, lengths, matrix);
        }
        if (j > 0 && matrix[i][j - 1] == 1) {
            checkNode(i, j - 1, lengths, matrix);
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
            checkNode(i, j + 1, lengths, matrix);
        }
    }

    /**
     * Have the function MatrixChallenge(strArr) take the strArr parameter being passed which will be a 2D matrix
     * of 0 and 1's, and determine the area of the largest square submatrix that contains all 1's.<br>
     * A square submatrix is one of equal width and height, and your program should return the area
     * of the largest submatrix that contains only 1's. For example:<br>
     * if strArr is ["10100", "10111", "11111", "10010"] then this looks like the following matrix:<br><br>
     *
     * 1 0 1 0 0<br>
     * 1 0 1 1 1<br>
     * 1 1 1 1 1<br>
     * 1 0 0 1 0<br><br>
     *
     * For the input above, you can see the bolded 1's create the largest square submatrix of size 2x2,
     * so your program should return the area which is 4. You can assume the input will not be empty.
     */
    public int MatrixChallenge(String[] strArr) {
        int rows = strArr.length;
        int cols = strArr[0].length();

        // Initialize a 2D array to store the dynamic programming results
        int[][] dp = new int[rows][cols];
        int maxSquareLen = 0;

        // Fill the dp array and calculate the size of the largest square submatrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (strArr[i].charAt(j) == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // First row or first column can only form a square of size 1
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        // __define-ocg__
        // Calculate the area of the largest square submatrix
        int varOcg = maxSquareLen * maxSquareLen;
        return varOcg;
    }
    public int MatrixChallengeVariant(String[] strArr) {

        int rowsCount = strArr.length;
        int colsCount = strArr[0].length();

        // Initialize a 2D array to store the dynamic programming results
        int[][] dp = new int[rowsCount][colsCount];
        int maxSquareLen = 0;

        // Fill the dp array and calculate the size of the largest square submatrix
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (strArr[i].charAt(j) == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // First row or first column can only form a square of size 1
                    } else {
                        // Verbose explanation for updating dp[i][j]
                        int aboveCell = dp[i-1][j];       // Value from the cell directly above
                        int leftCell = dp[i][j-1];        // Value from the cell directly to the left
                        int diagonalCell = dp[i-1][j-1];  // Value from the cell diagonally up-left
                        int smallestNeighbor;
//                        smallestNeighbor = Math.min(Math.min(aboveCell, leftCell), diagonalCell);
                        if (aboveCell < leftCell) {
                            smallestNeighbor = aboveCell;
                        } else {
                            smallestNeighbor = leftCell;
                        }
                        if (diagonalCell < smallestNeighbor) {
                            smallestNeighbor = diagonalCell;
                        }
                        dp[i][j] = smallestNeighbor + 1;  // Form the largest possible square ending at dp[i][j]
                    }
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        // Calculate the area of the largest square submatrix
        int result = maxSquareLen * maxSquareLen;
        return result;
    }

    /**
     * Capture the Rook - Schlag den Turm (Schach)<br><br>
     * Write a function that returns true if two rooks can attack each other, and false otherwise.<br>
     * @src https://edabit.com/challenge/rYD9NTBmNhaPM6wx2
     * @eval
     */
    public static Boolean canCapture(String[] array){
        if(array.length != 2)  {
            throw new IllegalArgumentException("Array must hold coordinates for two rooks.");
        }
        return array[0].charAt(0) == array[1].charAt(0) || array[0].charAt(1) == array[1].charAt(1);
    }



    /**
     * Quadrant Selection<br><br>
     * A common problem in mathematics is to determine which quadrant a given point lies in. There are four quadrants, numbered from
     * 1 to 4, as shown in the diagram below:<br>
     * For example, the point 4, which is at coordinates  (12,5)  lies in quadrant 1  since both its x and y  values are positive, and point
     *  B lies in quadrant 2 since its x value is negative and its y value is positive.<br>
     * Your job is to take a point and determine the quadrant it is in. You can assume that neither of the two coordinates will be 0
     * @src https://open.kattis.com/problems/quadrant
     */
    public static int getQuadrant(Integer x, Integer y){
        if(x == null || y == null || x == 0 || y == 0){
            throw new IllegalArgumentException("X and Y coordinate must be specified");
        }
        if((x < -1000 || x > 1000) && (y < -1000 || y > 1000)){
            throw new IllegalArgumentException("Coordinate range out -1000 > x|y < 1000 and != 0");
        }
        if(x < 0 && y < 0){
            return 3;
        } else if (x < 0 && y > 0){
            return 2;
        } else if (x > 0 && y < 0 ){
            return 4;
        } else {
            return 1;
        }
    }

    /**
     * You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?
     *
     * You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.
     *
     * For example, given the following matrix:
     *
     * [[0, 0, 1],
     *  [0, 0, 1],
     *  [1, 0, 0]]
     * Return two, as there are only two ways to get to the bottom right:
     *
     * Right, down, down, right
     * Down, right, down, right
     * The top left corner and bottom right corner will always be 0.
     * @src Daily Coding Problem: Problem #158 [Medium] by Slack
     */
    public static void getWaysToReackBottomRightInMatrix(int[][] matrix){
        int height = matrix.length - 1;
        int length = matrix[0].length - 1;

        while(height >= 0 & length >= 0){
            System.out.println("matrix[" + height +"]"+"["+ length + "]: " + matrix[height][length]);
            if(matrix[height][--length] == 0) {
                System.out.println("no wall left");
            }
            System.out.println("matrix[" + height +"]"+"["+ length + "]: " + matrix[height][length]);
            if(matrix[--height][length] == 0) {
                System.out.println("no wall above");
            }
        }
    }

}
