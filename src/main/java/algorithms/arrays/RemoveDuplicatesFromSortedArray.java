package algorithms.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if(current != nums[writeIndex-1]) {
                nums[writeIndex] = current;
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
