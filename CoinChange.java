/**
 * Time Complexity: O(m*n) where m is the coins.length and n is the amount
 * Space complexity: O(m*n)
 * Ran on leetcode? Yes
 * Any problems faced?: No
 *
 * The solution is using `zero one recursion` way of Dynamic programming
 *
 * Example - [1,2,5] and amount 11
 *
 * Representation of 2D array
 * --------------------------------------------------------------
 *   | 0 | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11
 * -------------------------------------------------------------
 * 0 | 0 | 12 | 12 | 12 | 12 | 12 | 12 | 12 | 12 | 12 | 12 | 12
 * --------------------------------------------------------------
 * 1 | 0 | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10 | 11
 * --------------------------------------------------------------
 * 2 | 0 | 1  | 1  | 2  | 2  | 3  | 3  | 4  | 4  | 5  | 5  | 6
 * --------------------------------------------------------------
 * 5 | 0 | 1  | 1  | 2  | 2  | 1  | 2  | 2  | 3  | 3  | 2  | 3
 * --------------------------------------------------------------
 *
 * Therefore, in this example last index of 2D array is the minimum count
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int currentDenomination = coins[i - 1];
                // if the amount is less than the denomination itself, use the value at row above
                if (j < currentDenomination) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Find the minimum among the two
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - currentDenomination]);
                }
            }
        }

        int result = dp[coins.length][amount];
        // this is the case when amount cannot be formed
        if (result == amount + 1)
            return -1;

        return result;
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] denominations = {1,2,5};
        int amount = 11;
        int result = obj.coinChange(denominations, amount);
        System.out.println("Result: " + result);
        assert (result == 3);

        denominations = new int[]{2,5};
        amount = 1;
        result = obj.coinChange(denominations, amount);
        System.out.println("Result: " + result);
        assert (result == -1);
    }
}
