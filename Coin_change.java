Time Complexity: O(n*m) where n is the amount and m is given coin denominations.
Space Complexity: O(n) where n is the given amount. As we have to declare an array of that size.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<amount+1; i++)
        {
            for(int j=0; j<coins.length; j++)
            {
                if(coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        if(dp[amount] > amount)
        {
            return -1;
        }
        else
        {
          return(dp[amount]); 
        }
        
    }
}