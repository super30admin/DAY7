// Time Complexity :O(coins.length * amount).   M*N
// Space Complexity :O(coins.length * amount). M*N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, 

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length; // Number of coins
        int n = amount; // Target amount
        int[][] dp = new int[m + 1][n + 1]; // DP table to store minimum coins for each subproblem

        // Initialize the dp array with base cases
        for (int i = 1; i <= n; i++) {
            dp[0][i] = amount + 1; // Use a large value to indicate an impossible situation
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    // If the current coin value is greater than the target amount,
                    // we cannot include this coin. So, we take the value from the previous row.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // If we can include the coin, we take the minimum of:
                    // 1. Not including the coin (value from the previous row)
                    // 2. Including the coin (1 + value of the remaining amount after including the coin)
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        // If dp[m][n] is greater than the amount, it means it's impossible to form the amount
        // with the given coins, so we return -1. Otherwise, we return dp[m][n].
        return dp[m][n] > amount ? -1 : dp[m][n];
    }
}
