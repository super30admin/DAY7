// Time Complexity : O (amount * coins.length)
// Space Complexity : O (amount * coins.length)
// Did this code successfully run on Leetcode : Yes


import java.util.Arrays;

// Your code here along with comments explaining your approach
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp array
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1); // initialize all to amount + 1 as that is an impossible value
        amounts[0] = 0; // F(0) = 0
        // for each a in amounts
        //     for each c in coins
        //         F(a) = min(F(a), 1 + F(a-c)) (where a-c > 0)
        // note that the index in amounts is the amount 'a' while the value amounts[i] is the number of coins
        for(int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    amounts[i] = Math.min(amounts[i], 1 + amounts[i - coin]);
                }
            }
        }
        // return last index of amounts if it was set, else return -1
        return (amounts[amount] == amount + 1) ? -1 : amounts[amount];
    }
}