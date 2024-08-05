// No. of coins required to make the amount
// TC: O(m*n) n: number of coins, m: amount
// SC: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int [n+1][amount+1];
        for(int i=1;i<=amount;i++) {
            dp[0][i] = 99999;
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=amount;j++) {
                // logic 
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j - coins[i-1]]+1);
            }   
        }
        if(dp[n][amount] == 99999) return -1;
        return dp[n][amount];
     }
}