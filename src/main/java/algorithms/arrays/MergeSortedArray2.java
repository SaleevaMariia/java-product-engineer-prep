package algorithms.arrays;

import java.util.Arrays;

public class MergeSortedArray2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 5, 6, 7};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    // Время: O(m + n)
    //Память: O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        for (int insertIndex = m + n - 1; insertIndex >= 0; insertIndex--) {
            if (n1 < 0) {
                nums1[insertIndex] = nums2[n2];
                n2--;
            } else {
                if (n2 < 0) {
                    nums1[insertIndex] = nums1[n1];
                    n1--;
                } else {
                    if (nums1[n1] > nums2[n2]) {
                        nums1[insertIndex] = nums1[n1];
                        n1--;
                    } else {
                        nums1[insertIndex] = nums2[n2];
                        n2--;
                    }
                }
            }
        }

    }
}
