// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Dynamic programming to compute the minimum number of coins needed to make the target amount
// by iterating through each coin denomination and updating a dp array where dp[j] stores the
// minimum number of coins required to form the amount

class CoinChangeWith1DArray {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        for (int j = 1; j <= n; j++) {
            dp[j] = amount + 1;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] > j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        int result = dp[n];
        if (result == amount + 1) return -1;
        return result;
    }
}