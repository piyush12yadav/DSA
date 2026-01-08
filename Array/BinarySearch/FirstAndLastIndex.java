package Array.BinarySearch;

import java.util.Arrays;

public class FirstAndLastIndex {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [3, 4]
    }
}

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];

        arr[0] = firstIndex(nums, target);
        arr[1] = lastIndex(nums, target);

        return arr;
    }

    static int firstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                end = mid - 1; // move left
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    static int lastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                start = mid + 1; // move right
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}


/*
To reduce line of code we can do like that


public int[] searchRange(int[] nums, int target) {
    return new int[]{
            binarySearch(nums, target, true),
            binarySearch(nums, target, false)
    };
}

private int binarySearch(int[] nums, int target, boolean findFirst) {
    int start = 0, end = nums.length - 1;
    int res = -1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            res = mid;
            if (findFirst) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else if (nums[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return res;
}

Calculate the time complexity = O(log n) + O(log n) = O(2 log n) =  O(log n)

Space Complexity: O(1)



 */