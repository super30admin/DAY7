// Time Complexity : O(mxn))
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;   
        int n = amount;
        // m+1 as we gonna have dummy row and n+1 as we gonna have 0 column
        int [][] dp = new int [m+1][n+1];

        //fill dummy row
        for(int j = 1; j <= n; j++){
            dp[0][j] = 99999;
        }

        //fill the matrix
        for(int i = 1; i <=m; i++){
            for(int j = 1; j <=n; j++){
                // till coin is lesser than dinominator, we have only 0 case
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[m][n] >= 99999) return -1;
        return dp[m][n];
    }
}