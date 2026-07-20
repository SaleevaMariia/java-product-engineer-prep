package java_core.immutable_review;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2, 4};
        System.out.println(removeElement(nums, 4));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != val) {
                nums[writeIndex++] = current;
            }
        }
        return writeIndex;
    }
}
