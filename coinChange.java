//Time Complexity: O(n*m)+O(n)+O(n*m) = O(n*m) where n is the length of coins array and m is the amount
//Space Complexity: O(n*m)

class coinChange {
    public int coinChange(int[] coins, int amount) {
        /*1. Create a dp array
          2. First fill array with Max value otherwise it will initialize with 0 and always take min 0 for every entry.
          3. For amount 0 the ways it can be constructed with these denominations = 0, so fill first col of all rows with zero.
          4. Start filling the dp array with values. For first row it will be qual to the value of j;
          5. For subsequent rows, we can use the coin at hand and use prev result i.e. amount - coinValue;
        */
        int len = coins.length;
        int[][] dp = new int [len][amount+1];
        for(int i=0; i < len; i++)
        {
            for(int j=0; j<=amount; j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0; i < len; i++)
            dp[i][0]=0;
 
        for(int i=0; i<len; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(i >=1)
                    dp[i][j]=dp[i-1][j];
                if(j>=coins[i])
                    if(dp[i][j-coins[i]] != Integer.MAX_VALUE)
                        dp[i][j]=Math.min(dp[i][j], 1 + dp[i][j-coins[i]]);
            }
        }
      return dp[len-1][amount]!=Integer.MAX_VALUE?dp[len-1][amount]:-1;  
        
    }
}