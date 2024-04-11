class Solution {
    // TC -> O(m X n), where m is number of coins and n is amount;
    // SC -> O(m X n)
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int rows = coins.length+1;
        int cols = amount+1;
        int[][] dp = new int[rows][cols];
        int res = -1;

        // First dummy col to zero
        for(int i=0; i<rows; i++){
            dp[i][0] = 0;
        }

        // First dummy row to infinity. When we take infinity, we get Integer Overflow, So take amount+1
        for(int j=1; j<cols; j++){
            dp[0][j] = amount+1;
        }

        // Fill Up the DP table
        for(int r=1; r < rows; r++){
            for(int c=1; c < cols; c++){
                if(coins[r-1] > c)
                    dp[r][c] = dp[r-1][c];
                else
                    dp[r][c] = Math.min(dp[r-1][c], dp[r][c - coins[r-1]] +1);
            }
        }

        if(dp[rows-1][cols-1] == amount + 1)
            return -1;
        return dp[rows-1][cols-1];
    }
}
