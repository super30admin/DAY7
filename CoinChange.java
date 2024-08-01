// Problem 322. Coin Change
// Time Complexity : O(m×n) m is the coin denominations, n is the amount
// Space Complexity : O(n) n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n + 1];

        // Initialize dp array with a value greater than the maximum possible coins needed
        for (int j = 1; j <= n; j++) {
            dp[j] = n + 1;
        }

        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        // Iterate over each coin
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                // Update dp array for each sub-amount
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        // Check if a solution was found
        return dp[n] > n ? -1 : dp[n];
    }
}
