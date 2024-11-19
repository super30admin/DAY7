// TC - O(M*N)
// SC - O(M*N)

// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4

public class CoinChangeDP {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] matrix = new int[coins.length + 1][amount + 1];
            matrix[0][0] = 0;
            for (int j = 1; j <= amount; j++) {
                matrix[0][j] = Integer.MAX_VALUE - 1;
            }

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    if (j < coins[i - 1]) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i - 1][j], 1 + matrix[i][j - coins[i - 1]]);
                    }
                }
            }

            return matrix[coins.length][amount] >= Integer.MAX_VALUE - 1 ? -1 : matrix[coins.length][amount];
        }
    }
}
