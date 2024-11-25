package main.java.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TreeProblems<T> {


    /**
     * Daily Coding Problem: Problem #8 [Easy]
     * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
     * Given the root to a binary tree, count the number of unival subtrees.
     *
     * @src This problem was asked by Google. Daily Coding Problem: Problem #8 [Easy]
     * @status unresolved
     */

    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] count = {0};
        countUnivalSubtreesHelper(root, count);
        return count[0];
    }

    private static boolean countUnivalSubtreesHelper(TreeNode node, int[] count) {
        // Base case: leaf node is always unival
        if (node.left == null && node.right == null) {
            count[0]++;
            return true;
        }

        // Check if left and right subtrees are unival
        boolean leftUnival = (node.left == null || countUnivalSubtreesHelper(node.left, count)) &&
                (node.left == null || node.left.val == node.val);

        boolean rightUnival = (node.right == null || countUnivalSubtreesHelper(node.right, count)) &&
                (node.right == null || node.right.val == node.val);

        // If current node is unival, increment count
        if (leftUnival && rightUnival) {
            count[0]++;
            return true;
        }

        return false;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Implement a stack API using only a heap. A stack implements the following methods:
     * push(item), which adds an element to the stack
     * pop(), which removes and returns the most recently added element (or throws an error if there is nothing on the stack)
     * Recall that a heap has the following operations:
     * push(item), which adds a new key to the heap
     * pop(), which removes and returns the max value of the heap
     * @src Daily Coding Problem: Problem #154 [Easy] by Amazon
     */
    private class StackUsingHeap<T> {
        private PriorityQueue<Pair> maxHeap;
        private int timestamp;

        // Constructor initializes the heap and the timestamp counter
        public StackUsingHeap() {
            this.maxHeap = new PriorityQueue<>((Comparator<Pair>) (p1, p2) -> {
                return Integer.compare(p2.timestamp, p1.timestamp);
            });
            this.timestamp = 0;
        }

        // Inner class to store each item with its timestamp
        private class Pair {
            T item;
            int timestamp;

            Pair(T item, int timestamp) {
                this.item = item;
                this.timestamp = timestamp;
            }
        }

        // Push an item onto the stack
        public void push(T item) {
            maxHeap.add(new Pair(item, timestamp++));
        }

        // Pop the most recently added item
        public T pop() {
            if (maxHeap.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return maxHeap.poll().item;
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }
    }
}
