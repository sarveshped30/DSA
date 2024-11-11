package org.example.dsa;

import java.util.Arrays;

public class NextPermutation {

    public NextPermutation() {

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the successor
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap the pivot with successor
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    // Helper method to swap two elements
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 3};
        nextPermutation(nums);
        System.out.println("Next lexicographical order: " + Arrays.toString(nums));
        
    }
}
