// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using a 2D matrix dp[i][j] where i represents the coins and j represents the target amount,
// and iteratively compute the minimum number of coins required to make amount,
// by considering both including and excluding each coin

public class CoinChangeWith2DArr {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        for (int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int result = dp[m][n];
        if (result == amount + 1) return -1;
        return result;
    }
}
