// Time Complexity : O(S*N) where S is the amount, n is denomination count.
// Space Complexity : O(S) : where S is the amount to change; We use extra space for the memoization table
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount +1];
        for(int j = 1;j<dp[0].length;j++){
            dp[0][j] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1] == amount + 1)
            return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}