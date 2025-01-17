import java.util.Arrays;

// Time Complexity :O(na) where nis no of coins and a is targetamount
// Space Complexity :O(a)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // DP array to store minimum coins for each amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // Initialize with a large value
        dp[0] = 0; // Base case: 0 coins needed for amount 0

        // Process each coin
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still a large value, return -1
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 10;
        System.out.println("Fewest coins required: " + coinChange(coins, amount)); // Output: 3
    }
    
}
