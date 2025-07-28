package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NextSmallerToLeft
 *
 * This class provides a utility to compute the "Next Smaller Element to the Left (NSL)"
 * for each element in a given array. For each index `i`, it finds the nearest smaller
 * element to the left of `arr[i]`. If no such element exists, it returns -1.
 *
 * Example:
 * Input:  [2, 1, 5, 6, 2, 3]
 * Output: [-1, -1, 1, 5, 1, 2]
 *
 * This is commonly used in problems like "Maximum Area Histogram", "Largest Rectangle in Histogram", etc.
 */

public class NextSmallerToLeft {
    public static void main(String[] args) {
        int[] arr = {2, 1 , 5 , 6, 2, 3};

        // Call the method to find next smaller elements to the left
        int[] nsl = nextSmallerToLeft(arr);

        // Print the result
        System.out.println(Arrays.toString(nsl));
    }

    /**
     * Finds the index-wise Next Smaller Element to the Left for each element in the input array.
     *
     * @param heights The input array of integers
     * @return An array where each element contains the nearest smaller element to the left
     */
    public static int[] nextSmallerToLeft(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];

        // Iterate through each element from left to right
        for (int i=0; i<heights.length; i++){

            // Pop from stack while the current top is >= current element
            while (!stack.isEmpty() && stack.peek() >= heights[i]){
                stack.pop();
            }

            // If stack is empty, no smaller element to left -> use -1
            // Else, the top of the stack is the next smaller element
            left[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to the stack for future comparisons
            stack.push(heights[i]);
        }

        return left;
    }
}

//Approach:
//
//        Use a monotonic stack (increasing stack).
//
//        If top of stack ≥ current element, pop until a smaller element is found.
//
//        If none found, result is -1.
//
//        Otherwise, result is the top of the stack.