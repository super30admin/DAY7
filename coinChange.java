//Time Complexity - O(m * n)
//Space Complexity - O(m * n)
// Approach - Initially the DP elements are initialized with 0. for the 0th row, ( coin of value zero) we can never find a 
// coins that will sum up to the range in j. So fill with infinity in this case amount + 1)
// each cell in the DP table is a sub problem that identifies the min number of coins to mnake that amount. 
// Case0 - when amount < coins[i-1] , we simply go with case0 where we consider the number of coins to make amount without including the current element. 
//Case1 - when amount >= coins[i-1] , we take minimum of case 0 and case1. 
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null){
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j=1; j < amount + 1; j++){
            dp[0][j] = amount +1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j=1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    //only case 0
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j - coins[i-1]]);
                }
        }
        }
        if(dp[coins.length][amount] == amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
    }

}