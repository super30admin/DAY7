// Time Complexity : O(N*M)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * using DP:
 *  initialize an array dp where dp[i] represents the minimum number of coins needed to make amount i.
 *  By iterating through each coin denomination and updating dp to reflect the minimum coins required for each amount
 *  (dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1)), 
 * we efficiently calculate the minimum number of coins needed to make the target amount.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [] dp = new int [n+1];
        for(int j = 1; j <= n; j++){
            dp[j] = 99999;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // case 1 is available
                if(j < coins[i-1]){ // till the time amount < denomination of curr coin
                // no choose case
                    dp[j] = dp[j];
                } else {
                // no choose case and choose
                // amount - denomination of curr coin
                    dp[j] = Math.min(dp[j], 1 + dp[j- coins[i-1]]);
                }
            }
        }
        int result = dp[n];
        if(result >= 99999){
            return -1;
        }
        return result;
    }
}