package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NextSmallerToRight
 *
 * This class finds the Next Smaller Element to the Right (NSR) for each element in the input array.
 * For every index `i`, it finds the closest smaller element to the right of `arr[i]`.
 * If no smaller element exists to the right, -1 is used.
 *
 * Example:
 * Input:  [2, 1, 5, 6, 2, 3]
 * Output: [1, -1, 2, 2, -1, -1]
 *
 * This is useful in problems like "Maximum Area Histogram", where finding boundaries is important.
 */
public class NextSmallerToRight {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int[] nsr = nextSmallerToRight(arr, 6);
        System.out.println(Arrays.toString(nsr));
    }


    /**
     * Returns an array representing the Next Smaller Element to the Right for each index in input array.
     *
     * @param heights The input array of integers
     * @param n       The number of elements in the input array
     * @return An array where each element holds the next smaller element to the right
     */


    private static int[] nextSmallerToRight(int[] heights, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are greater or equal to current
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element to the right exists
            right[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack for future comparisons
            stack.push(heights[i]);
        }

        return right;
    }
}


//🪜 Step-by-Step Approach
//        Initialize:
//
//        Stack s to keep track of next smaller candidates.
//
//        Output array right[] of same size as input.
//
//        Traverse from end to start (i = n-1 to 0):
//
//        While s is not empty and s.peek() >= arr[i], pop from stack.
//
//        If stack is empty → no smaller element → set right[i] = -1.
//
//        Else → top of stack is next smaller → set right[i] = s.peek().
//
//        Push arr[i] into stack.
//
//        Return the right[] array.


//🔁 Dry Run Example
//        Let’s dry run on:
//        arr = [2, 1, 5, 6, 2, 3]
//        We go from right to left:
//
//        i	arr[i]	Stack (before)	Action	Stack (after)	Output[i]
//        5	3	[]	Stack empty → -1	[3]	-1
//        4	2	[3]	Pop 3 (≥2), now empty → -1	[2]	-1
//        3	6	[2]	Top < 6 → 2 is answer	[2, 6]	2
//        2	5	[2, 6]	Pop 6 (≥5), Top = 2 → 2 is answer	[2, 5]	2
//        1	1	[2, 5]	Pop 5, Pop 2 → stack empty → -1	[1]	-1
//        0	2	[1]	Top < 2 → 1 is answer	[1, 2]	1
//
//        Final output: [1, -1, 2, 2, -1, -1]
//
//        📦 Time and Space Complexity
//        Metric	Value
//        Time Complexity	O(n)
//        Space Complexity	O(n)
//
//        🛠️ Real-World Usage (Why Learn This?)
//        🔲 Largest Rectangle in Histogram
//        Requires knowing next smaller to right and next smaller to left to compute width.
//
//        📊 Stock Span Problems, Sliding Window, Next Greater/Smaller Elements
//
//        📦 Monotonic Stack is used heavily in interview questions to optimize brute-force comparisons.
