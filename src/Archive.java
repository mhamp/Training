import dsa.MatrixProblems;
import main.java.utils.TimeTracedExecutor;

import java.util.*;

public class Archive {
//    public static void hello() {
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
//        MatrixProblems program = new MatrixProblems();
//        program.getRiverSizes(matrix);



//        program.addsToNumber(array, k);
//        for (int i = 1; i <= 100; i++)
//        System.out.println("Result for k=" + k +": " + program.addsToNumber(array, k));
//
//        String str = "Just an example here move along";
//        System.out.println("Word count for str=" + str +": " + program.getWordCount(str));
//
//        String str1 = "feminine";
//        String str2 = "nine";
//        long start = System.nanoTime();
//        boolean result = program.checkStringEnd(str1, str2);
//        long end = System.nanoTime();
//        long duration = end - start;
//        double durationInMilliseconds = duration / 1_000_000.0;
//        System.out.println("Result for str1 = " + str1 + " and str2 = " + str2 + ": " +  result + " in time :" + duration + " nanoseconds");
//        start = System.nanoTime();
//        result = program.checkEndOptimized(str1, str2);
//        end = System.nanoTime();
//        duration = end - start;
//        System.out.println("Result for str1 = " + str1 + " and str2 = " + str2 + ": " +  result + " in time :" + duration + " nanoseconds");
//
//        Long j = 50L;
//        System.out.println("Fibonacci for k = " + k + " : " + program.getFibonacciNumber(j, new HashMap<>()));
//
//        System.out.println("Triangular number for k = " + k + " : " + program.getTriangleNumber(k));
//
//        System.out.println("Triangular number variant for k = " + k + " : " + program.getTriangleNumber(k));
//        start = System.nanoTime();
//        Integer resultInt = program.getTriangleNumber(k);
//        end = System.nanoTime();
//        duration = end - start;
//        System.out.println("Triangular number for k = " + k + " : "+  resultInt + " in time :" + duration + " nanoseconds");
//
//        start = System.nanoTime();
//        resultInt = program.getTriangleNumberVariant(k);
//        end = System.nanoTime();
//        duration = end - start;
//        System.out.println("Triangular number variant for k = " + k + " : "+  resultInt + " in time :" + duration + " nanoseconds");
//
//        System.out.println("Basic calc: " + Program.basicCalculator(3, 100, "*"));
//
//        System.out.println("Insertaion sort: " + Program.insertionSort(array));
//        int year = 2026;
//        assert(Program.getPizzaPriceByYear(2021) == 1100): "Test failed for year 2021";
//        System.out.println("Test passed for year 2021");
//        assert(Program.getPizzaPriceByYear(2024) == 1400): "Test failed for year 2024";
//        System.out.println("Test passed for year 2024");
//        assert(Program.getPizzaPriceByYear(1993) == 1000): "Test failed for year 1993";
//        System.out.println("Test passed for year 1993");
//        System.out.println("Pizza price in year " +  year  + " : " + Program.getPizzaPriceByYear(year) + " ISK");
//
//
//
//        String input = "the incumbent will administer the spending of kindergarden milk money\n" +
//                "and exercise responsibility for making change he or she will share\n" +
//                "responsibility for the task of managing the money with the assistant\n" +
//                "whose skill and expertise shall ensure the successful spending exercise";
//        System.out.println("Employee salary: " + Program.evaluateSalary(input));
//
////        array = {3, 2, 1, -43};
//        System.out.print("Resulting products: [" );
//        for(int i : Program.getMultipesOfArrayExceptForArrayIndexI(array)){
//            System.out.print(i + ", " );
//        }
//        System.out.print("]" );
//
//        System.out.println("Resulting products: " + new TimeTracedExecutor<>(Program::getLowestPositiveNumberRevised)
//                .executeWithInput("get revised lowest positive Number", array));
//
//        TimeTracedExecutor<int[], int[], Integer> executor = new TimeTracedExecutor<>(Program::getIndexOfTwoSumAsAddingToTarget);
//        int[] result1 = executor.executeWithTwoInput("getIndexOfTwoSumAsAddingToTarget", array, 9);
//        System.out.println("Result: " + Arrays.toString(result1));
//
//        str ="Mathias Hamp";
//        System.out.println("Resulting name: " + new TimeTracedExecutor<>(Program::stutterWord)
//                .executeWithInput("stutterWord", str));
//
//        Program.TreeNode root = new Program.TreeNode(0);
//        root.left = new Program.TreeNode(1);
//        root.right = new Program.TreeNode(0);
//        root.right.left = new Program.TreeNode(1);
//        root.right.right = new Program.TreeNode(0);
//        root.right.left.left = new Program.TreeNode(1);
//        root.right.left.right = new Program.TreeNode(1);
//        int res = Program.countUnivalSubtrees(root);
//        System.out.println("Number of unival subtrees: " + res); // Output: 5
//
//        System.out.println(Program.autocompleteByPattern(new ArrayList<>(Arrays.asList("Matthias", "Manuel", "Miranda")), "ma"));
//
//        Arrays.stream(Program.getTriangleSideLengths(1)).forEach(value -> System.out.print(value + " "));
//
//        int[][] result2Darray = Program.squarePatch(3 );
//        System.out.println("[");
//        for (int i = 0; i < result2Darray.length; i++) {
//            System.out.print("[");
//            for (int p = 0; p < result2Darray[i].length; p++) {
//                System.out.print(result2Darray[i][p]);
//                if(p < result2Darray[i].length - 1){
//                    System.out.print(", ");
//                }
//            }
//            System.out.print("]");
//            if(i < result2Darray[i].length - 1){
//                System.out.println(", ");
//            }
//        }
//        System.out.println();
//        System.out.println("]");
//    }
//
//    public static List<List<Integer>> getKeyStats(List<String> songs){
//        List<List<Integer>> result = new ArrayList<>();
//        for(String song : songs){
//            if (song.length() > 200){
//                throw new IllegalArgumentException("Songs hava a max length <= 200.");
//            }
//        }

//        Map<Integer, Map<String, Integer>> keyStats = new HashMap<>();
//        for (int i = 1; i <= 10; i++) {
//            keyStats.put(i, new HashMap<>(Map.of("pressed", 0, "released", 0, "counter", 0)));
//        }

//        Map<String, List<Integer>> keys = new HashMap<>();
//        keys.put("c", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,9,10)));
//        keys.put("d", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,9,0)));
//        keys.put("e", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,8,0,0)));
//        keys.put("f", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,7,0,0,0)));
//        keys.put("g", new ArrayList<Integer>(Arrays.asList(0,2,3,4,0,0,0,0,0,0)));
//        keys.put("a", new ArrayList<Integer>(Arrays.asList(0,2,3,0,0,0,0,0,0,0)));
//        keys.put("b", new ArrayList<Integer>(Arrays.asList(0,2,0,0,0,0,0,0,0,0)));
//        keys.put("C", new ArrayList<Integer>(Arrays.asList(0,0,3,0,0,0,0,0,0,0)));
//        keys.put("D", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,8,9,0)));
//        keys.put("E", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,8,0,0)));
//        keys.put("F", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,7,0,0,0)));
//        keys.put("G", new ArrayList<Integer>(Arrays.asList(1,2,3,4,0,0,0,0,0,0)));
//        keys.put("A", new ArrayList<Integer>(Arrays.asList(1,2,3,0,0,0,0,0,0,0)));
//        keys.put("B", new ArrayList<Integer>(Arrays.asList(1,2,0,0,0,0,0,0,0,0)));
//
//        for(String song : songs){
//            for(char c : song.toCharArray()){
//                String key = String.valueOf(c);
//                if (keys.containsKey(key)) { // Check if the map contains the key
//                    List<Integer> values = keys.get(key);
//                    for (int i = 0; i < values.size(); i++) {
//                        if (values.get(i) != 0 && keyStats.get(i + 1).get("pressed") == 0) {
//                            keyStats.get(i + 1).put("pressed", 1);
//                        }
//                        if (values.get(i) == 0 && keyStats.get(i + 1).get("pressed") == 1) {
//                            keyStats.get(i + 1).put("pressed", 0);
//                            keyStats.get(i + 1).put("counter", keyStats.get(i + 1).get("counter") + 1);
//                        }
//                    }
//                } else {
//                    System.out.println("Key not found: " + key);
//                }
//            }
//            List<Integer> keyPressedBySong = new ArrayList<>();
//            for (int i = 0; i < 10;i++){
//                keyPressedBySong.add(keyStats.get(i + 1).get("counter"));
//                keyStats.get(i + 1).put("pressed", 0);
//                keyStats.get(i + 1).put("released", 0);
//                keyStats.get(i + 1).put("counter", 0);
//            }
//            result.add(keyPressedBySong);
//        }
//        return result;
//    }


}
