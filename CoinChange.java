/*
    Leetcode problem 322: Coin Change
    T.C: O(m * n) :: S.C: O(m * n) : m - length of coins array, n - amount

    Solved using bottom-up dp approach, as there are 2 decision parameters
    we can create a 2D array (select rows to be coins and columns as sums 
    until the amount). Store the recursively calculated sum from the previously
    selected coins in the dp array, before storing calculate the min of the two
    decisions that can be made select the current coin or get previous result.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int leastcoins = 0;

        if (coins == null || coins.length == 0 || amount == 0) return leastcoins;

        int m = coins.length;
        int n = amount;
        int[][]  dp = new int[m + 1][n + 1];

        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        if (dp[m][n] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return dp[m][n];
    }
}