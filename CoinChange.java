/* Description: Here, while observing recursion tree, we get that there are many repeated subproblems of type 0-1 recursion. So using DP.
There are 2 decision making factors, one is when we are out of coins, and second is when the amount becomes zero or negative. 
Therefore, we are storing the subproblems values in 2D array. Also, we observed that for each 0 case, we find the value right above it and for 
each 1 case we find the value in same row and column index at amount - coins[i-1] where i-1 is the current coin value.  */
// Time Complexity : O(m * n) - where m is the coins array length and n is the amount
// Space Complexity : O(m * n) - where m is the coins array length and n is the amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
// Brute force which is failing with time limit exceeded
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        /*
         * Base case - when we dont have any coins and there is some integer amount
         * given in input, it is not possible to calculate change
         */
        if (coins.length == 0 || coins == null) {
            return -1;
        }
        // Calling the recurse function with initial values
        return recurse(coins, amount, 0, 0);
    }

    private int recurse(int[] coins, int amount, int index, int coinsUsed) {
        // Base Condition for this recurse function:
        /*
         * 1. Checking if we dont have any coins in coins array or if the amount is
         * negative, in that case we should stop recursion
         */
        if (coins.length == index || amount < 0) {
            // This will return minus 1 to the integers case1/case2
            return -1;
        }
        /*
         * 2. If the amount the is zero and we have found number of coins for the
         * change, in this case also we will stop recursion
         */
        if (amount == 0) {
            // This will return number of coins used to the integers case1/case2
            return coinsUsed;
        }
        // Logic: 2 cases:
        // 0 or dont pick the coin case
        int case1 = recurse(coins, amount, index + 1, coinsUsed);
        // 1 or pick the coin case
        int case2 = recurse(coins, amount - coins[index], index, coinsUsed + 1);

        // Once we have ended the recursion, check
        // If value of case1 is -1, then return only case2
        if (case1 == -1) {
            return case2;
        }
        // If value of case2 is -1, then return only case1
        if (case2 == -1) {
            return case1;
        }

        // If we have number of coins used in both case1 and case2, pick the minimum
        return Math.min(case1, case2);
    }
}

// Optimize approach by storing sub problem values in 2D array
class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
         * Base case - when we dont have any coins and there is some integer amount
         * given in input, it is not possible to calculate change
         */
        if (coins.length == 0 || coins == null) {
            return -1;
        }
        // Declare a 2d array to store the value of each subproblem
        int[][] dp = new int[coins.length + 1][amount + 1];
        // We are adding a dummy row with 0 value coin and dummy column with 0 amount,
        // rows are value of coins, columns are amount
        // So it is not possible to make amount 1 to 11 with 0 value coin, hence
        // declaring them infinity(our infinity is amount + 1)
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }

        /*
         * By default arrays have 0 values, so cell 0,0 will be 0 and first column where
         * we have make amount 0 will be 0 by default
         * Suppose Amount = 11 and coins=[1,2,5]. Then row will be from 0,1,2,5 and
         * column will be 0,1,2,3,...,11
         * And dummy values and infinity values will be:
         * [[0,12,12,12,12,12,12,12,12,12,12,12],
         * [0,...],
         * [0,...],
         * [0,...]]
         * This is how we have initialized and rest values we will be storing with
         * formula
         */

        /*
         * Now running a for loop from 1 to coins.length + 1 (plus 1 bcoz we have dummy
         * value 0 also)
         */
        for (int i = 1; i < coins.length + 1; i++) {
            // Inner for loop from 1 to amount + 1 (plus 1 bcoz we have dummy value 0 also)
            for (int j = 1; j < amount + 1; j++) {
                /*
                 * Checking if amount we have to make i.e. j is less than the value of coin, in
                 * that we cannot give change by picking current coin. So we will have only
                 * 0(dont pick) case here
                 */
                if (j < coins[i - 1]) {
                    /*
                     * In 0 case, we can get the value just one row above the current and same
                     * column
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * Else if amount is proper, we have 2 cases 0 and 1 and we will pick min value
                     * 0 case same. In 1 case, we get the value in same row but column at (current
                     * column index - curr coin value) position
                     */
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        /*
         * Check if the ans that we have got in the last row and last col, is that
         * infinity? If yes, return -1
         */
        if (dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        // Else return the min number of coins used
        return dp[coins.length][amount];
    }
}