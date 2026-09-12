package algorithms.arrays;

import java.util.Arrays;

public class SquaresSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, -3, -2, -1};
        int[] nums2 = sortedSquares(nums);
        System.out.println(Arrays.toString(nums2));
    }
   // Время: O(n)
   // Память: O(n)
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        while (index < nums.length - 1 && nums[index] < 0) {
            index++;
        }
        int left = index - 1;
        int right = index;
        if (nums[0] >= 0) {
            left = -1;
            right = 0;
        }
        if (nums[index] < 0) {
            left = nums.length - 1;
            right = nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (left < 0) {
                result[i] = nums[right] * nums[right];
                right++;
            } else {
                if (right >= nums.length) {
                    result[i] = nums[left] * nums[left];
                    left--;
                } else {
                    if (nums[left] * nums[left] < nums[right] * nums[right]) {
                        result[i] = nums[left] * nums[left];
                        left--;
                    } else {
                        result[i] = nums[right] * nums[right];
                        right++;
                    }
                }
            }
        }

        return result;
    }
}
