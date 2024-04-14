// Time Complexity : O(coins.length * amount)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// //Approach : Recursive approach -> it will be of exponential time complexit 2^(n+m) and time limit exceeded in leetcode
// Bottom up approach/ Tabulation - We are taking the matrix of coins and amount and calculating the min no of coins required to reach the amount
class CoinChange {
    //Time complexity O(coins.length * amount)
    // Space O(n)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount + 1;

        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int coin : coins) {
            for(int i=coin;i<=amount;i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}