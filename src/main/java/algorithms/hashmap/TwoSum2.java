package algorithms.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] numsExample = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numsExample, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valueToIndex.containsKey(complement)) {
                return new int[]{valueToIndex.get(complement), i};
            } else {
                valueToIndex.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("indexes wasn't found");
    }
}
