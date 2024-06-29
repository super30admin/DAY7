// Time Complexity :O(N)
// Space Complexity :O(n). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        // Handle edge case where there is only one house
        if (nums.length == 1) return nums[0];
        
        // Initialize dp array to store the maximum amount that can be robbed up to each house
        int[] dp = new int[nums.length];
        
        // Base cases
        dp[0] = nums[0]; // If there's only one house to rob
        dp[1] = Math.max(dp[0], nums[1]); // Max value between robbing the first or the second house
        
        // Iterate over the remaining houses, starting from the third house
        for (int i = 2; i < dp.length; i++) {
            // Choose the maximum between not robbing the current house (dp[i-1]) and
            // robbing the current house plus the maximum from two houses before (nums[i] + dp[i-2])
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        
        // The last element in dp array contains the maximum amount that can be robbed
        return dp[nums.length - 1];
    }
}
