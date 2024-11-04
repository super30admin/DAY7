//time Complexity :O(m*n) m is number of coin denomination and n is amount
// Space Complexity ;O(m*n)
// run in leetcode : yes
// problems in execution: No


import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1]; // extra row and column for 0

        // Fill the first row with "infinity" for unreachable amounts
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 99999;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) { // Current amount is less than the denomination
                    dp[i][j] = dp[i - 1][j]; // Can't choose this coin
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // Min of not choosing vs choosing
                }
            }
        }

        // If the amount is not reachable, return -1
        return dp[m][n] >= 99999 ? -1 : dp[m][n];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        // Example 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Example 1 Output: " + solver.coinChange(coins1, amount1)); // Output: 3

        // Example 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Example 2 Output: " + solver.coinChange(coins2, amount2)); // Output: -1

        // Example 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Example 3 Output: " + solver.coinChange(coins3, amount3)); // Output: 0
    }
}
