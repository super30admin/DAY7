package coinChange;

// bottom up approach
// dp approach

// Time Complexity : O(m∗n).
// m is the different number of coins and n is the different amoutns which we need to make
//On each step the algorithm finds the next F(i) in n iterations, where 1≤i≤S.
// Space Complexity : O(m) extra step for memorisation table
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class DpApproach {


    public static void main(String[] args) {

//        int[] coins = {1, 2, 5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

        int[] coins = {1};
        int amount = 0;

        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        // cause array starts from index 0 and we need amount of 11
        // This table will store the answer to our sub problems
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // initialise it to 0 as to achieve 0 amount we need 0 coins
         /*
      The answer to making change with minimum coins for 0
      will always be 0 coins no matter what the coins we are
      given are
    */
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

                }

            }
        }

         /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then
      return -1.
      Otherwise, dp[amount] holds the answer
    */

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
