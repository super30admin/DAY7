// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 1) {
            if(amount == coins[0]) return 1;
            else if(amount < coins[0]) return -1;
        }

        int max = amount + 1;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int j = 1; j <= n; j++) {
            dp[0][j] = max;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int res = dp[m][n];
        if(res >= amount + 1) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5, 10};
        int amount1 = 35;
        int amount2 = 78;
        System.out.println("Minimum coins from coins1 to " +
                "build " + amount1 + " is " + coinChange(coins1, amount1));
        System.out.println("Minimum coins from coins1 to " +
                "build " + amount2 + " is " + coinChange(coins1, amount2));
    }
}
