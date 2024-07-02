/*
    1. Time Complexity : O(m*n) - m - number of coins, n - amount
    2. Space Complexity : O(n)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

import java.util.Arrays;
class Solution {
    static int[] dp;
    public static int getChange(int[] coins, int amount) {
        if (dp[amount] != Integer.MAX_VALUE) return dp[amount];
        int min = Integer.MAX_VALUE, res;
        for (int i = 0; i < coins.length; ++i) {
            if (amount >= coins[i]) {
                res = getChange(coins, amount - coins[i]);
                if(res >= 0)
                    min = Math.min(min, res);
            }      
        }
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        return dp[amount];

    }
    public static int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int ans = getChange(coins, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int min;
        for (int i = 1; i <= amount; ++i){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; ++j) {
                if(i >= coins[j]){
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? min :  min + 1;
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println("Using Memoisation -- Min coins is:"+coinChange(coins, amount));
        System.out.println("Using Tabulation -- Min coins is:"+coinChange2(coins, amount));
    }
}