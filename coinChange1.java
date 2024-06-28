/*
TC --> O(n*m)
SC --> O(n*m)
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //col 1 is 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        // row 1 will be infinity
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = 99999;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                //not taken
                int not_taken = dp[i - 1][j];
                int taken = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    taken = dp[i][j - coins[i - 1]] + 1;
                }
                dp[i][j] = Math.min(taken, not_taken);

            }//for
        }//for

        int val = dp[n][amount];
        if (val == 99999) {
            return -1;
        }
        return val;

    }//method
}//class
