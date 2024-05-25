public class CoinChange {
}

/**

 L.C: 322.Coin Change

 Approach: Dynamic programing 2d matrix

 Result: Minimum no of coins count to make the given amount

 Working:
     create a dp matrix of coins length+1 and amount+1
     i - coins from 0 ... EOI
     j - amount from 0 ... amount
     Fill the first row with i.e index i=0 (coin 0) an j = 1 ... amount
     with amount+1 (considered as infinite) since range in j cannot form with coin zero
     for each (i,j) store how may coins from (0 to i) will be used to form the amount j
         only ZERO CASE if amt < coin
         MIN of (ZERO CASE) and (ONE CASE+1) // add +1 since we choose a coin
     //base exit case for -1
     return the last i,j of the index of the dp matrix

 Time Complexity: O(m*n)
 Space Complexity: O(m*n)
 */

class Solution {
    public int coinChange(int[] coins, int amount) {


        if(coins == null || coins.length == 0) {
            return -1;
        }


        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=1;i<amount+1; i++) {
            dp[0][i] = amount+1;
        }

        for(int i=1;i<coins.length+1; i++) {

            for(int j=1;j<amount+1; j++) {

                /*
                    negative amount
                    amt j = 1, pick a coin [2],
                    zero case [0]^1
                    one case [2]^-1 , we will ignore the negative amount case, only use the zero case in this seneriao
                 */
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];  //zero case
                }
                else{
                    //min of ZERO and ONE case, adding 1 to the one case since we are choosing a coin
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }

        //if the amount cannot be formed with the given coins
        if(dp[coins.length][amount] == amount+1) {
            return -1;
        }
        return dp[coins.length][amount];
    }

/*
    Recursive solution

    private int recurse(int[] coins, int amount, int index, int coinUsed) {

        //Base
        if(amount < 0 || index == coins.length) {
            return -1;
        }
        if(amount == 0) {
            return coinUsed;
        }

        //logic
        //zero case
        int case1 = recurse(coins, amount, index+1, coinUsed);
        //one case
        int case2 = recurse(coins, amount-coins[index], index, coinUsed+1);

        if(case1 == -1) {
            return case2;
        }
        if(case2 == -1) {
            return case1;
        }

        return Math.min(case1, case2);
    }
*/
}