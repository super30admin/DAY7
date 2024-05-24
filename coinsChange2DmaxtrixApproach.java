/*
 * Approach:
 * 
 * Time comp: O(m*n) m - coins.length; n - amount
 * Space comp: O(m*n)
 */

 class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int [][] dp = new int[coins.length + 1][amount + 1]; // 2 parameters used for decision making

        // starting from 1 to have a dummy case as 0
        for(int j = 1; j < amount + 1; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j< amount + 1; j++){ // j = amount
                if(j < coins[i - 1]) { // only when the amount is less than element in the array
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(1 + (dp[i][j - coins[i - 1]]),dp[i - 1][j]);
                }

            }
        }
        if(dp[coins.length][amount] == amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
        
    }

}