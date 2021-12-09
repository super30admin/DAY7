// Time Complexity : O(n*m)
// Space Complexity :o(n*m); where m is no. of coins and n is amount
// Did this code successfully run on Leetcode :yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0||coins==null)
            return 0;
        int[][] dp=new int[coins.length+1][amount+1];
        for(int j=0;j<amount+1;j++)
            dp[0][j]=amount+1;
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }

       if(dp[coins.length][amount]>amount)
           return -1;
        else
            return dp[coins.length][amount];
    }
}