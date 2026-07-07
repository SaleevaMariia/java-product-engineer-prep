package algorithms.hashset;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            int current = nums[i];
            if (elements.contains(current)){
                return true;
            }
            elements.add(current);
        }
        return false;
    }
}
