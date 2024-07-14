class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = coins.length; // Number of different coins
        int n = amount; // Target amount
        
        // Initialize the DP table with size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the first row (dp[0][j]) with amount + 1 except dp[0][0]
        for (int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1; // Filling the first row with an invalid maximum amount for automated value
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // If the coin's value is greater than the amount, exclude the coin
                } else {
                    // Take the minimum of excluding the coin or including it
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        // The answer will be in dp[m][n], check if it's valid
        int res = dp[m][n];
        if (res > amount) {
            return -1; // If the value is greater than amount, return -1
        } else {
            return res; // Otherwise, return the result
        }
    }
}
