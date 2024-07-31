// Time Complexity: O(n)
// Space Complexity: O(n)
// House Robber

class Solution {
    public int rob(int[] nums) {
        // Edge case: if there are no houses, the maximum money robbed is 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        // Edge case: if there is only one house, return the money in that house
        if (n == 1) {
            return nums[0];
        }

        // Initialize a dp array to store the maximum money that can be robbed up to
        // each house
        int[] dp = new int[n];

        // Base cases:
        // The maximum money that can be robbed from the first house is the money in the
        // first house
        dp[0] = nums[0];
        // The maximum money that can be robbed from the first two houses is the maximum
        // of the two houses
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array using the recurrence relation
        for (int i = 2; i < n; i++) {
            // Either do not rob the current house and take the maximum up to the previous
            // house,
            // or rob the current house and add its money to the maximum up to two houses
            // back
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        // The answer is the maximum money that can be robbed up to the last house
        return dp[n - 1];
    }
}