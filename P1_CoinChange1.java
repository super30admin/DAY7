// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        for(int j = 1 ; j<=m ; j++) {
            dp[0][j] = 99999;
        }
        for(int i=0 ; i<=n ; i++ ) {
            dp[i][0] = 0;
        }
        for(int i = 1 ; i<= n ; i++) {
            for(int j = 1 ; j<= m ; j++) {
                if((j-coins[i-1]) < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+(dp[i][j-coins[i-1]]));
                }
            }
        }
        if(dp[n][m] >= 99999) return -1;
        return dp[n][m];
    }
}