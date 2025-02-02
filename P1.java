// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length; int n = amount;
        int[][] dp = new int[m + 1][n + 1];     //initialise dp array with extra row for dummy values 
        for (int j = 1; j <= n; j ++) {
            dp[0][j] = amount + 1;              //zeroth case for helping us create other cases
        }

        for (int i = 1; i <= m; i ++) {     //iterate over each coin
            for (int j = 1; j <= n; j ++) {     //iterate over each amount
                if (coins[i - 1] > j) {         // If the Coin Value is Larger than amount
                    dp[i][j] = dp[i - 1][j];    // Do not take the coin
                    
                } else {                        //If the Coin Value is Less Than or Equal to amount

                    //Do not take the coin → Keep the previous value: dp[i - 1][j]
                    //Take the coin → Add 1 to the count and check remaining amount (j - coins[i-1]).
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);     
                }
            }
        }
        int re = dp[m][n];
        if (re >= amount + 1) return -1;
        return re;
    }
}
