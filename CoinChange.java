// Time Complexity : O(mn)
// Space Complexity : 2D array - O(mn), 1D array - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2-D array
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null) return -1;

        int[][] dp = new int[coins.length+1][amount+1];

        for(int j = 1; j<amount+1; j++) {
            dp[0][j] = amount+1;
        }

        for(int i = 1; i<coins.length+1; i++) {
            for(int j = 1; j<amount+1; j++) {
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[coins.length][amount] == amount+1) return -1;
        return dp[coins.length][amount];
    }
}
*/

// 1-D array
class Solution {
  public int coinChange(int[] coins, int amount) {
    // Edge cases.
    if(coins.length==0 || coins==null) return -1;

    int[] dp = new int[amount+1];
    // Initialising the initial array.
    for(int j = 1; j<amount+1; j++) {
      dp[j] = amount+1;
    }

    for(int coin: coins) {
      for(int j = coin; j<amount+1; j++) {
        // Calculating the minimum number of coins required for that amount.
        dp[j] = Math.min(dp[j], 1+dp[j-coin]);
      }
    }

    return dp[amount]>amount ? -1 : dp[amount];
  }
}