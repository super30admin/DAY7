// Approach 1:
    // TC: O(m*n), where m = number of coins and n = amount
    // SC: O(m*n), includes recursion stack space aswell
    
// Approach 2:
    // TC:O(m*n), where m = number of coins and n = amount
    // SC: O(m*n)

// Approach 3:
    // TC:O(m*n), where m = number of coins and n = amount
    // SC: O(m)

import java.util.*;

// Approach 1: Recursion + Memoization
class Solution1 {
    private long memo(int coins[], int amount, int i, long dp[][]) {
        if (i == 0) {
            return (amount % coins[0] == 0) ? amount / coins[0] : Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        long pick = Integer.MAX_VALUE;
        if (amount >= coins[i])
            pick = 1 + memo(coins, amount - coins[i], i, dp);
        long nonPick = memo(coins, amount, i - 1, dp);
        return dp[i][amount] = Math.min(pick, nonPick);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[][] = new long[n][amount + 1];
        for (long x[] : dp) {
            Arrays.fill(x, -1);
        }
        long ans = memo(coins, amount, n - 1, dp);
        return (ans >= Integer.MAX_VALUE) ? -1 : (int) ans;
    }
}

// Approach 2: Tabulation with 2D Array
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        long dp[][] = new long[n][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[0][i] = (i % coins[0] == 0) ? i / coins[0] : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (j >= coins[i])
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i]]);
            }
        }
        return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : (int) dp[n - 1][amount];
    }
}

// Approach 3: Tabulation with 1D Array
class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        long prev[] = new long[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            prev[i] = (i % coins[0] == 0) ? i / coins[0] : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            long dp[] = new long[amount + 1];
            for (int j = 1; j <= amount; j++) {
                dp[j] = Integer.MAX_VALUE;
                dp[j] = Math.min(dp[j], prev[j]);
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
            prev = dp;
        }
        return prev[amount] == Integer.MAX_VALUE ? -1 : (int) prev[amount];
    }
}