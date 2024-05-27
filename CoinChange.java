// Time Complexity : O(m*n) where m = length of coins array, n = amount
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:

// logic: Create a dynamic programming table where rows represent the coins and columns represent the amount.
// Initialize the table with a value greater than the target amount.
// Iterate through each coin and amount, updating the table with the minimum number of coins needed to make up the amount.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if( coins == null || coins.length == 0){
            return -1;
        }

        int[][]dp = new int[coins.length+1][amount+1];

        for(int i =1; i <= amount ; i++){
            dp[0][i] = amount+1;
        }
        for(int i =1; i <= coins.length; i++){
            for(int j =1 ; j<=amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1 );
                }
            }
        }
        if(dp[coins.length][amount]== amount+1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}