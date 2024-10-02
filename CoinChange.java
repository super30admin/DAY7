// Time complexity: O(m*n)
// Space Complexity: O(n+1)
class CoinChange{
   public int coinChange(int[] coins, int amount){

      int m = coins.length;
      int n = amount;

      int[][] dp = new int[m +1][n +1];

      for(int j = 1; j <= n; j++){
         dp[0][j] = amount +1;// ivalid values so put like intmax 
         //to reach amount in row using 0 will be invalid
      }

      for(int i = 1; i <= m; i ++){
         for(int j = 1; j <= n; j++){
            if(j < coins[i-1]){
               dp[i][j] = dp[i-1][j];// no availability case 0 choose case
               // value comes from right above
               //TC- O(mn)
               //SC- O(mn)

            }
            else{
               dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);//both case semario, choose case and no choose
            }
         }
      }

      if(dp[m][n] > amount) return -1;

      return dp[m][n];
   }
}