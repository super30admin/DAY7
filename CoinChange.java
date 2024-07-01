// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class CoinChange {

    // using Tabulation
    public int coinChange(int[] coins, int amount) {

        int m = coins.length;
        int n = amount;

        int[][]dp = new int[m+1][n+1];

        for(int j= 1; j<=n ; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                // case 1 is available
                if(j < coins[i-1]) { // when the amount is less than denomination of current coin
                    // no choose case - fill from above row until the time amount < denomination of current coin
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // no choose and choose case
                    dp[i][j] =  Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        int res = dp[m][n];

        if(res >= Integer.MAX_VALUE - 1){
            return -1;
        }


        return res;

    }


}