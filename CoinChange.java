//Recursive Approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    public int helper(int [] coins, int amount, int index, int coinsUsed){
        //Base Condition
        if(amount == 0){
            return coinsUsed;
        }
        if(amount < 0 || index == coins.length){
            return -1;
        }
        //logic
        //Case 0 or no coins used
        int case1 = helper(coins, amount, index + 1, coinsUsed);
        //Case 1 or coins used case
        int case2 = helper(coins, amount-coins[index], index, coinsUsed+1);
        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1,case2);
    }
}
//DP approach
class Solution {

    // Time Complexity : 0(m*n) where m is the no. of coins, and n is the amount
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I created a DP table where I initially filled the 0 row with
    //infinity as there are no possible that any amount can be made from 0 coins. I took rows as coins and amount as column
    //Then I checked the given amount is possible checking the data available of the computation is already done or take the
    //amount from the previous coins used if the no. of coins is not computed yet.

    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int [coins.length+1][amount+1];
        for(int j = 1; j < amount + 1; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}