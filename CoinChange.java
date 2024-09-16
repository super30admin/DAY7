// Time Complexity : O(n) where n is array size
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);   //populate with value > amount, so that if dp[last_index]>amount, return -1
        dp[0]=0;
        for(int i=0;i<=amount;i++)	//i represents all the values from 0 to amount. Different values in stages of forming the amount
		{
            for(int j = 0;j<coins.length;j++)	//traversing through coins array
            {
                if(coins[j]<=i)                                 //only if coin value is less than sum
                {
                    dp[i]= Math.min(dp[i],dp[i-coins[j]]+1);    //number of coins for current sum would be 1 more than number of coins for (i-coin_value) sum.
                }
            }
        }
            return dp[amount]>amount?-1:dp[amount];
    }
}