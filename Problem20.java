// Time Complexity: O(n * m)
// Space Complexity: O(n)
// The Coin Change

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize dp array with a value greater than the possible number of coins required
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case: 0 coins needed to make amount 0
        
        // Fill the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        // If dp[amount] is still greater than amount, it means it's not possible to make that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}