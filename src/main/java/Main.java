

import dsa.ArrayProblems;
import dsa.MatrixProblems;
import dsa.sorting.MergeSort;
import utils.ArrayPrinter;
import utils.RandomArrayGenerator;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting properly");

//        int[][] matrix = {
//                {1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1},
//                {1, 1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 0}
//        };
//        int[] array = { 1, 5, 2, 67, 3, 55};
//        int k = 215;
//        MatrixProblems.getRiverSizes(matrix);
//        Scanner scanner = new Scanner(System.in); // Create a single Scanner instance for System.in
//        boolean continued = true;
//
//        while (continued) {
//            System.out.println("Enter the integer: ");
//            try {
//                int num = scanner.nextInt(); // Read the integer input
//                System.out.println("Smallest amount of squared integer components for " + num + ": "
//                        + ArrayProblems.getSmallestSquaredIntComponent(num));
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.next(); // Clear the invalid input
//                continue; // Go back to the start of the loop
//            }
//
//            // Ask if the user wants to continue
//            System.out.println("Continue y/n?");
//            String response = scanner.next();
//            continued = response.equalsIgnoreCase("y");
//        }
//
//        scanner.close(); // Close the Scanner only once at the end
//
//        int[][] matrix = {
//                {0, 1, 1},
//                {0, 1, 1},
//                {0, 0, 0}
//        };
//        MatrixProblems.getWaysToReackBottomRightInMatrix(matrix);

        int[] numbers = RandomArrayGenerator.getRandomArray(20);
        System.out.println("Before: ");
        ArrayPrinter.printArray(numbers);
        MergeSort.mergeSort(numbers);
        System.out.println("After: ");
        ArrayPrinter.printArray(numbers);

    }
}