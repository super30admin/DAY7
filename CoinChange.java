// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
 * Approach: bottom up approach, where we solve the sub-problems and use them to solve the whole problem
 * 1. imagine coins are rows and amount is column and add buffer to it at index-0 both row and column
 * 2. 0 -index of first row start 1 is set to max - because we cannot create the amount x>=1 with 0 coins.
 * 3. if the amount value is less than the coinValue -> we borrow from previous value in the same column -> column is constant
 * 4. if the amount value is greater than the coinvalue -> we can either borrow the min from above column or we can get 1+ the value of the sub problem where column is j-coins[i-1]- 
 *      row is constant
 * 5. return accordingly
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[][] cache = new int[coins.length + 1][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            cache[0][j] = 999999;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    cache[i][j] = cache[i - 1][j]; // getting the top value
                } else {
                    cache[i][j] = Math.min(cache[i - 1][j], 1 + cache[i][j - coins[i - 1]]);
                }
            }
        }

        if (cache[coins.length][amount] == 999999)
            return -1;

        return cache[coins.length][amount];
    }

}