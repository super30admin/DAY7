import java.util.*;

class Solution {
    
    // Time Complexity : O(SN) where S is amount and N is number of coins
    // Space Complexity : O(S) where S is amount
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Couldn't come up with solution on my own


    // Your code here along with comments explaining your approach
    /**
     * Coin change (bottom up approach)
     * 1. start from 1 till amount
     * 2. calculate minimum number of coins required for 1 till actual amount
     */


    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
        
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Couldn't come up with solution on my own


    // Your code here along with comments explaining your approach
    /**
     * House Robber
     * 1. question demands to find maximum sum of elements in array which have at least one element in between.
     * 2. To find such sum, we can keep track of 2 previous sums.
     * 3. Compare the previous sum with the (current element + previous sum) and update the maximum of those.
     */

    public int rob(int[] nums) {

        int prev1 = 0;
        int prev2 = 0;

        for(int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }

        return prev1;
    }
}
