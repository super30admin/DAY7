// Time complexity:- O(m * n) m is the coin's length and n is the amount
// Space complexity:- O(m * n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Approach: 
 * In this problem we have to find the minimum number of coins needed to make up a given amount using an infinite supply of coins. 
 * I used dynamic programming to find the minimum number of coins needed to make a given amount. I initialized a 2D array dp where dp[i][j] 
 * stores the minimum coins required to make amount j using the first i coins. In this algorithm, I iterated through the coins and amounts, updated
 * the dp table by considering whether to include the current coin or not, and finally returned the value at dp[coins.length][amount], or -1 if no solution is found.
 */ 
class Solution {
    public int coinChange(int[] coins, int amount) {

        // Base condition
        if(coins == null || coins.length == 0) {
            return -1;
        }

        // Initialize a 2D DP array with (coins.length + 1) rows and (amount + 1) columns
        // dp[i][j] will represent the minimum number of coins needed to make amount j using the first i coins.
        int[][] dp = new int[coins.length+1][amount+1];

        //Fill the first row with infinity.
        // This represents an impossible solution for any amount > 0 when no coins are available.
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }

        // Iterate over the dp array starting from the second row and column
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                // If current amount is smaller than the value of the coin then fill the matrix 
                // dp at row given by i and column given by j
                if(j < coins[i - 1]) {
                    // fill with same column and row minus 1
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, we calculate the minimum between two cases:
                    // 1. We don't use the current coin: dp[i - 1][j]
                    // 2. We use the current coin: 1 + dp[i][j - coins[i - 1]]
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        // If the value in dp[coins.length][amount] is still amount + 1,
        // it means no combination of coins can make the target amount.
        if(dp[coins.length][amount] == amount +1) {
            return - 1;
        }

        // Return the minimum number of coins needed to make the given amount
        return dp[coins.length][amount];            
    }
}

    