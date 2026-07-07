package algorithms.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int current = nums[i];
            int complement = target - current;
            Integer value = valueToIndex.get(complement);
            if( value != null){
                return new int[]{value, i};
            }
            valueToIndex.put(current, i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
