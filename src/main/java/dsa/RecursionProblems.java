package dsa;

public class RecursionProblems {

    /**
     * Have the function RecursionChallenge(num) take the num parameter being passed and return the factorial of it.<br>
     * For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. For the test cases,
     * the range will be between 1 and 18 and the input will always be an integer.<br>
     * @src coderbyte problem posed by SEG
     */
    public int RecursionChallenge(int num) {
        // __define-ocg__
        int result = calculateFactorial(num);
        return result;
    }

    private static int calculateFactorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * calculateFactorial(num - 1);
        }
    }

    /**
     * Recursive Hello print statement (Easy)
     * If you have an integer and you want to print it with a certain number of digits,
     * padding with leading zeros if necessary, you can use %0Nd, where N is the total width of the number including zeros.
     * @param i
     * @learning avoid while loop as termination condition since the recursive call immediately starts another while loop,
     * without ever returning to the previous while loop, causing the initial loop to effectively halt and never complete its iterations.
     */
    public static synchronized void sayHiRecursion(int i){
//        while(i > 0){
        if (i > 0) {
            System.out.println(i + ": " + "Hello!");
            sayHiRecursion(--i);
        }
    }
    /**
     *
     *
     * @src  https://youtu.be/k-7jJP7QFEM?si=JdJ8utXgGPD6sR2u&t=453
     */
    private static void sayHiRecursionWithExit(int count){
        System.out.println("hi!");
        if(count >= 1){
            return;
        }
        sayHiRecursionWithExit(count - 1);
    }


    /**
     * Recursion: Array Sum<br><br>
     * Write a function that finds the sum of an array. Make your function recursive.<br>
     * @param arr
     * @src https://edabit.com/challenge/hf2THAoQRQbAx2jc9
     */
    public static int arraySum(int[] arr) {
        int sum = 0;
        int[] copied = new int[arr.length - 1];
        for(int i = 0; i < copied.length; i++){
            copied[i] = arr[i];
            sum += arraySum(copied);
        }
        return sum;
    }

    /**
     * On java.lang.System.arraycopy() method
     *
     * public static void arraycopy(Object source_arr, int sourcePos,
     *                             Object dest_arr, int destPos, int len)
     * Parameters :
     * source_arr : array to be copied from
     * sourcePos : starting position in source array from where to copy
     * dest_arr : array to be copied in
     * destPos : starting position in destination array, where to copy in
     * len : total no. of components to be copied.
     * @param arr
     * @return
     */
    public static int arraySumRevised(int[] arr) {
        // Base case: if the array is empty, return 0
        if (arr.length == 0) {
            return 0;
        }
        // Recursive case: sum the first element and the sum of the rest of the array
        int[] rest = new int[arr.length - 1];
        System.arraycopy(arr, 1, rest, 0, arr.length - 1);
        return arr[0] + arraySumRevised(rest);
    }


}
