// TC - O(2^(M+N)) => Number of Nodes per Node = 2 and Levels = (M-1)Take + (N)Don't take
// SC - O(2^(M+N))

// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4

public class CoinChangeRecursion {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int minCoins = helper(coins, amount, 0, 0);
            if (minCoins == Integer.MAX_VALUE) {
                return -1;
            }
            return minCoins;
        }

        private int helper(int[] coins, int amount, int index, int count) {
            // Base Case - amount=0, index>=coins.length, amount<0
            if (amount < 0 || index >= coins.length) {
                return Integer.MAX_VALUE;
            }
            if (amount == 0) {
                return count;
            }
            // Take current coin
            int countWithCurrCoin = helper(coins, amount - coins[index], index, count + 1);
            // Don't take current coin
            int countWithoutCurrCoin = helper(coins, amount, index + 1, count);

            return Math.min(countWithCurrCoin, countWithoutCurrCoin);
        }
    }
}
