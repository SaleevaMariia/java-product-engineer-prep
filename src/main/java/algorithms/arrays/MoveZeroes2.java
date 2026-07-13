package algorithms.arrays;

import java.util.Arrays;

public class MoveZeroes2 {
    public static void main(String[] args) {
        int[] example = new int[]{0, 1, 0, 3, 12};
        moveZeroes(example);
        System.out.println(Arrays.toString(example));
    }

    public static void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
            }
        }
        for (int i = writeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
