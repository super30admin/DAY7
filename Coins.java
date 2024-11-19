// This Optimal Solution takes about O(nm + m) complexity where n is the number of coins + 1 and m is amount + 1.
//The space complexity of this problem is O(nm)

class Solution {
  public int coinChange(int[] coins, int amount) {
    if(coins.length == 0)
      return 0;
    else{
      int coinRow = coins.length + 1;
      int amountColumn = amount + 1;
      int [][]dp = new int[coinRow][amountColumn];//Having an extra row to 0 for coins and amount
      //Filling the first column with max amount value
      for(int i = 1;i<amountColumn;i++){
        dp[0][i] = 9999;
      }
      for(int i=1;i<coinRow;i++){
        for(int j=1;j<amountColumn;j++){
          if(j < coins[i-1]){
            //copying the previous row elements if amount is less than coin denomination
            dp[i][j] = dp[i-1][j];
          }
          else{
            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
          }
        }
      }
      int result = dp[coinRow-1][amountColumn-1];
      if(result >= 9999) return -1;
      return result;
    }

  }
}