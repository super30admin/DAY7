/*
    LC - 322. Coin Change
    TC - O(mn)
    SC - O(mn)
    Approach -
        By using problem statment, I can understand that it needs exhaustive recursion to find the solution.
        By using recursion of pick / no pick approach, I can solve this problem.
        But time complexity will be exponential which is O(2^n)

        To reduce the time & space complexity, I can bottom up approach to solve this problem.
        where I have two cases, using the solution of sub problem, it can be solved with above mentioned time
        complexity.

        Cases are: 
            if amount < coins (coins of which we can able to achieve that target amount), then i can pick the solution of
            above row same column.
            else 
                find the minimum of above row same column value and 1 + another solved subproblem [i][j - coins[i - 1]]
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}