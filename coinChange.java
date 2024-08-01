//time O(n)
//space O(n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize dp to amount + 1 (effectively infinity)
        dp[0] = 0; 

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // Take the minimum
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; 
    }
}

