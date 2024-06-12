// Time Complexity : brute force O(2^n), dp O(m*n)
// Space Complexity : dp O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/coin-change/
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 *
 */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
       if(coins == null || coins.length == 0) return 0;
    
        return dp(coins, amount);
    }
    
    //DP solution - time o(m*n), space o(m*n)
    private int dp(int[] coins, int amount){
        
        /*
         row for coins (including one row for coin 0)
         column for amounts (including one dummy column for amount 0)
        */
        int[][] dp = new int[coins.length+1][amount+1];
        int infinity = amount+1;
        
        //usig coin 0, to make non zero amount will need infinity coins
        for(int i=1; i < amount+1; i++)
            dp[0][i] = infinity;
        
        for(int i=1; i < coins.length+1; i++) {
            for(int j=1; j < amount+1; j++) {
                //if current amount is less than current coin, can not select that coin,
                // do not choose coin case
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else
                {
                    //else we have both options choose or not choose, take min from those
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j- coins[i-1]] + 1);
                }
            }
        }
        
        int res = dp[coins.length][amount];
        //infinity check
        if(res == infinity) 
            return -1;
        else 
            return res;
    }
    
    private int bruteForce(int[] coins, int amount, int index, int min) {
        
        //base, derived from logic, what is changing in logic
        if(amount == 0) return min;
        
        //if amount goes negative or we run out of coins, that is invalid path
        if(amount < 0 || index == coins.length) return -1;
        
        //logic
        //each step we either chose coin or not chose coin
        
        //choose coin, amount reduces by current coin, index remains same 
        //as we have unlimited supply of coins, min increases by 1 since we choose coin
        int case1 = bruteForce(coins, amount - coins[index], index, min + 1);
        
        //do not choose coin, only index increases as we move to next coin
        int case2 = bruteForce(coins, amount, index+1, min);
        
        if(case1==-1) return case2;
        
        if(case2==-1) return case1;
        
        return Math.min(case1, case2);
        
    }
}