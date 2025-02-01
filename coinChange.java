// Problem1 (https://leetcode.com/problems/coin-change/)

// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * For this problem dynamic programming is used. Here, the tabulation has a dummy row which is filled with values greater than amount except for 
 * amount 0. For the remaining rows, until the coin values of row is less than the amount, the vaues from the above row are filles and for the
 * remaining columns, the minimum of the above rows value and the value that is coins value places before the current column +1 is taken.
 * The value at [m][n]th place is returned with the minimun number of coins required. If that value is greater than amount then return -1 i.e.,
 * no way amount is matched with the coins. In other case the value is minimun number of coins required.
 */


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][]dp = new int[m+1][n+1];
        dp[0][0] =0;
        for(int j = 1; j<=n;j++){
            dp[0][j] = amount + 1;    // dummy row with amount greater 
        }
        // write conditions according to the tabulation
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                // till compensation is less than amount
                if(coins[i-1] > j){ // since in coins array we dont have dummy
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[m][n];
        if(result>=amount+1){
            return -1;
        }
        return result;
    }
}