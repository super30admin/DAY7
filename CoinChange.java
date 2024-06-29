// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* At each subproblem we have two cases, wether to choose the current coin or not. We have two variables at each step, the denominations of coins available and the total sum to be made 
  At each step/iteration we find the min number of coins needed to make that sum with the subset od denominations available. 
  We also consider  two cases, when we dont choose the coin, the minimum and the total remain same as the previous subset, when we choose the coin, the minimum is the sum of current coin plus plus the minimum found with same subset for (total - current coin denomination)
  The final element in the matrix gives the answer. */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // null case
        if(amount == 0) return 0;
        if(coins.length == 1) {
            if(amount == coins[0]) return 1;
            else if(amount < coins[0]) return -1;
        }
        // create matrix of num of coins needed for each denomination to reach target
        // add dummy row at the beginning and populate it with max value
        // get min of previous row or (denominations x target -current amt)

        // last element gives the answer

        int n = coins.length;
        int m = amount;
        int max = 999999;
        int[][] matrix = new int[n+1][m+1];
        matrix[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            matrix[0][i] = max;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (i < coins[j-1]) {
                    matrix[j][i] = matrix[j - 1][i];
                } else {
                    matrix[j][i] = Math.min(matrix[j - 1][i],1+ matrix[j][i - coins[j - 1]]);
                }

            }
        }
        int res = matrix[n][m]; 
        return  res >= 999999? -1 : matrix[n][m];
    }

}