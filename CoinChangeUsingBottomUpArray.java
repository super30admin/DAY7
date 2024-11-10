/*
Time Complexity: O(m*n)

Space Complexity: O(n)

Did this code successfully run on Leetcode: Yes

Note: Refer Notebook for array calculation

 */

public class CoinChangeUsingBottomUpArray
{
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1]; //extra row and column for 0
        //dp[0][0] = 0; by default value is 0 so we don't need to initialize it

        for(int j=1; j<=n; j++)
        {
            dp[j] = amount+1;
        }

        for(int i=1; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {

                if(j < coins[i-1]) {  //0 < coins[0], 0 < 2, then choose case is not available
                    dp[j] = dp[j]; //no choose case will be at same position in array
                }
                else {
                    /*
                    no choose case => dp[i][j],
                    choose case => 1+dp[i][j-coins[i-1]]
                    */
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }

                /*
                OR
                No choose case is at the same place so just calculate choose case where j should be greater or equal to denomination

                if(j >= coins[i-1]) {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }

                 */
            }

        }

        if(dp[n] >= amount+1)
            return -1;

        return dp[n];
    }
}