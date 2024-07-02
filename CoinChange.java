// Time Complexity: O(amount * n), where n is the number of coins
// Space Complexity: O(amount), for the result array
import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    result[i] = Math.min(result[i], 1 + result[i - coins[j]]);
                }
            }
        }

        if (result[amount] <= amount) {
            return result[amount];
        }
        return -1;
    }
}
