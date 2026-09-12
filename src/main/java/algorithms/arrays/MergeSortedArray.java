package algorithms.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    // Время: O(m + n)
    //Память: O(m + n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0;
        int n2 = 0;
        int[] result = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (n1 == m) {
                for (int j = i; j < m + n; j++) {
                    result[j] = nums2[n2++];
                }
                break;
            }
            if (n2 == n) {
                for (int j = i; j < m + n; j++) {
                    result[j] = nums1[n1++];
                }
                break;
            }
            if (nums1[n1] < nums2[n2]) {
                result[i] = nums1[n1++];
            } else {
                result[i] = nums2[n2++];
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}
