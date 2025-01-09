class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for (int j = 1; j < coins.length + 1; j++) {
            for (int i = 1; i < amount + 1; i++) {
                if (i < coins[j - 1]) {
                    dp[j][i] = dp[j - 1][i];
                } else {
                    dp[j][i] = Math.min(dp[j - 1][i],
                            1 + dp[j][i - coins[j - 1]]);
                }
            }
        }
        if (dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}