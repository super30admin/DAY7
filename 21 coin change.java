// Time Complexity : O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int coinChange(int[] coins, int amount) {
        //aesha
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }
        int result = dp[m][n];
        if (result > amount) {
            return -1;
        } else
            return result;
    }
}
            
   
