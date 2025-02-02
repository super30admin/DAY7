// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity : O(m*n) where m is the number of coins and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:
// We are using a 2D dp array to store the minimum number of coins required to make the amount.
// We are iterating over the coins and amount and checking if the current coin is greater than the amount, then we are taking the value from the previous row. If the current coin is less than or equal to the amount, then we are taking the minimum of the value from the previous row and 1+ the value at the current row and the amount minus the current coin. We are returning the value at the last row and last column. If the value is Integer.MAX_VALUE, then we are returning -1.

public class Problem1 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 0;

        for(int i = 1; i <= n; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        int res = dp[m][n];
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
}
