class Solution {
    // Time Complexity : O(mn), where m is the no of different coin denominations and n is amount to be formed from them.
    // Space Complexity : O(mn)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        int r = dp.length;
        int c = dp[0].length;
        for(int i = 0; i < c; i++) {
            dp[0][i] = amount+1;
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[r-1][c-1] == amount+1 ? -1 : dp[r-1][c-1] ;
    }
}