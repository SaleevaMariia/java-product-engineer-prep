package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3};
        System.out.println(majorityElement2(nums));

    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int nextCount = numToCount.getOrDefault(current, 0) + 1;
            numToCount.put(current, nextCount);
            if (nextCount > nums.length / 2) {
                return current;
            }
        }
        throw new IllegalStateException("Majority element is guaranteed but was not found");
    }

    public static int majorityElement2(int[] nums) {
        int count = 0;
        int major = 0;
        for (int i = 0; i < nums.length; i++){
            int current = nums[i];
            if (count == 0){
                major = current;
            }
            if (current == major){
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
