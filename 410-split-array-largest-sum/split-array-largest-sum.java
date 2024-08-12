class Solution {
    // Helper function to check if the array can be split into k or fewer subarrays with max sum <= mid
    public boolean check(int[] nums, int k, int mid) {
        int count = 1; // Start with one subarray
        int sum = 0; // Sum of the current subarray

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + sum > mid) {
                count++; // Need to start a new subarray
                sum = nums[i]; // Start new subarray with current element
            } else {
                sum += nums[i]; // Add current element to current subarray
            }
        }

        return count <= k; // Return true if we can split into k or fewer subarrays
    }

    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE; // Lower bound of binary search (max element in array)
        int r = 0; // Upper bound of binary search (sum of all elements in array)
        int res = 0;

        // Calculate the initial bounds
        for (int i = 0; i < nums.length; i++) {
            r += nums[i];
            l = Math.max(l, nums[i]);
        }

        // Binary search to find the minimum possible maximum subarray sum
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(nums, k, mid)) {
                res = mid; // Possible answer
                r = mid - 1; // Try for a smaller maximum sum
            } else {
                l = mid + 1; // Increase the possible maximum sum
            }
        }

        return res; // Return the minimum possible maximum subarray sum
    }
}