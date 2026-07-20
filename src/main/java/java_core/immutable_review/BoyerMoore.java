package java_core.immutable_review;

public class BoyerMoore {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 5, 5, 5, 6, 7};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int current : nums) {
            if (count == 0) {
                candidate = current;
            }
            if (current == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
