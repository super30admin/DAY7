// TC - O(M*N)
// SC - O(M)

// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4

public class CoinChangeSingleArrayDP {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] matrix = new int[amount + 1];
            matrix[0] = 0;
            for (int j = 1; j <= amount; j++) {
                matrix[j] = Integer.MAX_VALUE - 1;
            }

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    // if (j < coins[i - 1]) {
                    //     matrix[j] = matrix[j];
                    // } else {
                    //     matrix[j] = Math.min(matrix[j], 1 + matrix[j - coins[i - 1]]);
                    // }

                    if (j >= coins[i - 1]) {
                        matrix[j] = Math.min(matrix[j], 1 + matrix[j - coins[i - 1]]);
                    }
                }
            }

            return matrix[amount] >= Integer.MAX_VALUE - 1 ? -1 : matrix[amount];
        }
    }
}
