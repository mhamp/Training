package dsa;

public class PatternPrintingProblems {
    /**
     * Triangular Number Sequence<br><br>
     * This Triangular Number Sequence is generated from a pattern of dots that form a triangle.
     * The first 5 numbers of the sequence, or dots, are:<br>
     * 1, 3, 6, 10, 15. This means that the first triangle has just one dot, the second one has three dots,
     * the third one has 6 dots and so on.<br>
     * Write a function that returns the number of dots when given its corresponding triangle number of the sequence.<br>
     * @param k
     * @return int
     */
    public int getTriangleNumber(int k){
        return k * (k+1) / 2;
    }

    public int getTriangleNumberVariant(int k){
        int result = 0;
        for (int i = k; i > 0; i--){
            result = result + i;
        }
        return result;
    }


    /**
     * Perfect Square Patch<br><br>
     * Create a function that takes an integer and outputs an n x n square solely consisting of the integer n.<br>
     * @param n
     * @src https://edabit.com/challenge/7Tb7qMDQHtz3xpydd
     */
    public static int[][] squarePatch(int n) {
        int[][] matrix = new int[n][n];
        for(int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                matrix[j][i] = n;
            }
        }
        return matrix;
    }


}
