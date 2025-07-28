package Stack;

import java.util.Stack;


//✅ Approach: Single-Pass Stack Method (Optimized)
//        🔍 Goal:
//        Find the maximum rectangular area that can be formed using contiguous bars in a histogram.
//
//        🧠 Core Idea:
//        Use a stack to keep track of indices of increasing bar heights.
//
//        If the current bar is shorter than the bar at the top of the stack:
//
//        We found a right boundary for the top bar.
//
//        Use the previous element in the stack as the left boundary.
//
//        Pop and calculate area using:
//        area = height[top] * width, where
//        width = i - stack.peek() - 1 (or i if stack is empty).
//
//        At the end, flush remaining items in stack using height 0.
//
//        🔁 Dry Run on Input: [2, 1, 5, 6, 2, 3]
//        i	currHeight	Stack	Action	Area	maxArea
//        0	2	[]	Push 0
//        1	1	[0]	Pop 0 (2), width = 1	2×1 = 2	2
//        []	Push 1
//        2	5	[1]	Push 2
//        3	6	[1,2]	Push 3
//        4	2	[1,2,3]	Pop 3 (6), width = 1	6×1 = 6	6
//        [1,2]	Pop 2 (5), width = 2	5×2 = 10	10
//        [1]	Push 4
//        5	3	[1,4]	Push 5
//        6	0 (fake)	[1,4,5]	Pop 5 (3), width = 1	3×1 = 3	10
//        [1,4]	Pop 4 (2), width = 3	2×3 = 6	10
//        [1]	Pop 1 (1), width = 6	1×6 = 6	10
//        []	Done
//
//        ✅ Final maxArea = 10
//


public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};

        int max = largestRectangleArea(arr);
        System.out.println(max);
    }

    public static  int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++){
            int currHeight = (i==n) ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){

                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }
                else {
                    width = i - stack.peek() -1;
                }

                int area = height * width;
                maxArea = Math.max(area , maxArea);
            }

            stack.push(i);
        }

        return maxArea;
    }

}





//
//
///** Second 2 apporach
// * MaxHistogramWithNSRNSL
// *
// * This class provides a method to calculate the maximum rectangular area
// * in a histogram using the concept of Next Smaller to Right (NSR) and
// * Next Smaller to Left (NSL).
// *
// * Time Complexity: O(n) for each pass → Total: O(n)
// */
//public class MaxHistogramWithNSRNSL {
//
//    public static void main(String[] args) {
//        int[] histogram = {2, 1, 5, 6, 2, 3};
//
//        // Compute the maximum area
//        int maxArea = largestRectangleArea(histogram);
//
//        System.out.println("Maximum area of histogram: " + maxArea); // Output: 10
//    }
//
//    /**
//     * Calculates the largest rectangular area in a histogram
//     *
//     * @param heights array representing histogram bar heights
//     * @return maximum rectangular area
//     */
//    public static int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//
//        // Get indices of next smaller elements to the right and left
//        int[] NSR = nextSmallerToRight(heights, n);
//        int[] NSL = nextSmallerToLeft(heights, n);
//
//        int maxArea = 0;
//
//        // Calculate area for each bar
//        for (int i = 0; i < n; i++) {
//            int width = NSR[i] - NSL[i] - 1;
//            int area = heights[i] * width;
//            maxArea = Math.max(maxArea, area);
//        }
//
//        return maxArea;
//    }
//
//    /**
//     * Finds the index of the next smaller element to the right of each element.
//     *
//     * @param heights input histogram array
//     * @param n       number of bars
//     * @return array of indices of the next smaller element to the right
//     */
//    private static int[] nextSmallerToRight(int[] heights, int n) {
//        Stack<Integer> stack = new Stack<>();
//        int[] right = new int[n];
//
//        for (int i = n - 1; i >= 0; i--) {
//            // Maintain a stack of increasing height indices
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//
//            // If no smaller element to the right, use n (virtual boundary)
//            right[i] = stack.isEmpty() ? n : stack.peek();
//            stack.push(i);
//        }
//
//        return right;
//    }
//
//    /**
//     * Finds the index of the next smaller element to the left of each element.
//     *
//     * @param heights input histogram array
//     * @param n       number of bars
//     * @return array of indices of the next smaller element to the left
//     */
//    private static int[] nextSmallerToLeft(int[] heights, int n) {
//        Stack<Integer> stack = new Stack<>();
//        int[] left = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            // Maintain a stack of increasing height indices
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//
//            // If no smaller element to the left, use -1 (virtual boundary)
//            left[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//
//        return left;
//    }
//}
