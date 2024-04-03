// Time Complexity: O(n*m), where n is the number of coins and m is the amount. 
//                 The nested loops iterate through each coin for each amount, so it's proportional to the product of the number of coins and the amount.
// Space Complexity: O(n*m), where n is the number of coins and m is the amount.
//                   The space used by the dynamic programming table (dp) is proportional to the product of the number of coins and the amount.
// Approach: Dynamic Programming.
//           The approach uses a bottom-up dynamic programming approach to find the minimum number of coins required to make up the given amount.
//           It iterates through each coin denomination and each possible amount, filling the dp table accordingly.
//           The value at dp[i][j] represents the minimum number of coins required to make up the amount j using the first i coins.
//           It handles cases where the amount is less than the denomination of the current coin and updates the dp table accordingly.
//           Finally, it returns the value at dp[n][m] if it's less than infinity (99999), otherwise -1.
// leetcode link: https://leetcode.com/problems/coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
    if(coins == null || coins.length ==0) return 0;
    int n = coins.length;
    int m = amount;
    int[][] dp = new int[n+1][m+1];
    //first row

    for(int j=1; j<=m; j++)
    {
        dp[0][j] = 99999; // infinity
    }

    for(int i=1; i< dp.length; i++)
    {
        for(int j=1; j<dp[0].length; j++)
        {
            //negative amount
            // amount is smaller than denomination of coin
            if(j < coins[i-1])
            {
                // case0
                dp[i][j] = dp[i-1][j];
            }
            else
            {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
            }
        }
    }
    if(dp[n][m] >= 99999) return -1;
    return dp[n][m];
    }
}