// Time Complexity : O(mn) --> where m is amount and n is length of array
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode (322): yes
// Any problem you faced while coding this : No

// Explanation: In this 'Coin Change' problem we are creating a 2D array of size numeber of coins and amount size. We are then traversing over this 2D array to compute the minimum number of coins required to get a particular amount and storing this information for future use cases. In this way we are eliminating the computation of similar sub-cases (like we had in using recurssion method). And in each index we are taking the minimum value from both the cases i.e. (1) to choose a coint or (2) to not choose the coin. Going with this method, we are able to solve the problem in linear time i.e. O(mn).

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        
        int dp[][] = new int [coins.length + 1][amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 9999;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        
        int result = dp[dp.length - 1][dp[0].length - 1];
        if (result >= 9999) return -1;
        return result;
    }
}