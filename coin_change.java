// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null ||  coins.length ==0){
            return -1; 
        }
        int dp[][] = new int[coins.length +1][amount+1]; // +1 for dummy 

        for(int j=1; j<amount + 1; j++){
            dp[0][j] = amount + 1;
        }
        for(int i=1; i < coins.length+1; i++){
            for(int j = 1; j< amount+1; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount+1){ // if no solution found return -1
            return -1;
        }
        return dp[coins.length][amount];
    }
}