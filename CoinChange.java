public class CoinChange {

    //time complexity: O(n*m)
    //space complexity: O(n*m)
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length ==0){
         return -1;
        } 
        int[][] dp = new int [coins.length+1][amount+1];
 
        // fill the 0 coin row
        for (int i =1; i< dp[0].length;i++){
         dp[0][i] = amount +1;
        }
        // fill the 0 answer column
        for (int i = 0; i< dp.length;i++){
         dp[i][0] = 0; // not necessary
        }
 
        for (int i = 1; i <= coins.length;i++ ){
             for (int j = 1; j <= amount; j++){
                     if (j < coins[i-1]){
                             dp[i][j] = dp[i-1][j];
                     } else {
                             dp[i][j] = Math.min (dp[i-1][j],dp[i][j-coins[i-1]]+1);
                     }
             }
        }
        if (dp[coins.length][amount] == amount +1){
         return -1;
        }
        return dp[coins.length][amount];
 
 
     }
}
