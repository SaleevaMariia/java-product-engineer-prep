package algorithms.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++){
            int current = nums[i];
            if (current != 0){
                if(writeIndex != i){
                    nums[writeIndex] = nums[i];
                    nums[i] = 0;
                }
                writeIndex++;
            }
        }
    }
}
