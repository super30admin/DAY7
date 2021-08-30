//T:O(mn) where m is no of possible coins and n is amounts possible
//S:O(n) where n is amounts possible(optimized)

public class Solution {
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount+1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    if(dp[amount] > amount)
      return -1;
    return dp[amount];
  }
}
