class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;

        int[][] dp = new int [m+1][amount+1];
        for (int j = 1; j <= amount; j++){
            dp[0][j] = 99999;
        }

        for (int i = 1; i <= m; i++){
            for( int j = 1; j <= amount; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if (dp[m][amount] == 99999) return -1;
        return dp[m][amount];
    }
}
