// Time Complexity : O(n * amount)
// Space Complexity : O(n * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return - 1;
        }
        int[][] dp= new int[coins.length + 1][amount+1]; // extra +1 cause of 0 case
        for(int j = 1; j < amount + 1; j++){
            dp[0][j] = amount+1; // initializing 0 case to amount + 1, infinity
        }
        for(int i = 1; i < coins.length + 1 ; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){ // current amount is less than the current coin value
                    dp[i][j] = dp[i-1][j]; // take the value from the row above
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]); // take the minimum value among, the row above or difference of current value and value of that coin in the dp array
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1){ // no solution found, 
            return -1;
        }
        return dp[coins.length][amount]; // return the last element
    }
}