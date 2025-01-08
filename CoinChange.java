// Time Complexity: For the first exhaustive approach. TC is O(2 ^ n). 
// as the recursion is stacked on other. For the DP approach, 
// TC is O(m x n), number of coins and total amount

// Space Complexity: O(n) as the recursion stack is utilized. O(n ^ 2) as the 2D array is being utilized.
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChangeUsingExhaustive(new int[] { 1, 2, 5 }, 11)); // 3
        System.out.println(coinChangeUsingDP(new int[] { 1, 2, 5 }, 11)); // 3

    }

    // In this approach, I got Time Exceeded Error on Leetcode. Hence the optimized
    // approach is coded below.
    public static int coinChangeUsingExhaustive(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        return recurse(coins, amount, 0, 0);
    }

    private static int recurse(int[] coins, int amount, int index, int coinsUsed) {
        // base case on which the recursion should stop
        if (index == coins.length || amount < 0) {
            return -1;
        }
        if (amount == 0)
            return coinsUsed;
        // logic
        int case1 = recurse(coins, amount, index + 1, coinsUsed);
        int case2 = recurse(coins, amount - coins[index], index, coinsUsed + 1);
        if (case1 == -1)
            return case2;
        if (case2 == -1)
            return case1;
        return Math.min(case1, case2);
    }

    // Value of the problem is being fetched from the previous problem being solved.
    // Thats how the computation time is reduced.
    private static int coinChangeUsingDP(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int dp[][] = new int[coins.length + 1][amount + 1];

        // first row is set to amount + 1(except [0][0]) here so that the computation
        // becomes easy and extra conditions are avoided
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        // i - 1 denotes the previous row
        // j - 1 denotes previous column
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = j < coins[i - 1] ? dp[i - 1][j] : Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }
        if (dp[coins.length][amount] == amount + 1)
            return -1;
        return dp[coins.length][amount];
    }

}