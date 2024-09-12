// Time Complexity : O(S*n) - S is the amount given and n is the no of coins given
// Space Complexity : O(S) - S is the amount given
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    /**
     * For each coin, chk by using that coin and substracting the coin val from amount the best that can be formed using that amt
     * @param coins
     * @param amount
     * @return min no of coins required to make the amt
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int c: coins){
            for (int a = c; a <= amount; a++){
                dp[a] = Math.min(dp[a], dp[a - c] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}