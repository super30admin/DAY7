package coinChange;

//top down approach
// non-dp approach

// Time Complexity : logrithmic Thus, the worst-case time complexity is **O(2ⁿ) ** (since each coin can be either included or excluded independently).
// Space Complexity : the space complexity is O(m) due to recursive stack usage.
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded exception

public class Exhaustive {


    public static void main(String[] args) {

//        int[] coins = {1, 2, 5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

        int[] coins = {1};
        int amount = 0;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int result = helper(coins, 0, amount);

        if(result > 9999) {
            return -1;
        }

        return result;
    }

    private static int helper(int[] coins, int idx, int amount) {

        // base
        if(amount == 0) {
            return 0;
        }

        if(amount < 0 || idx == coins.length) {
            // to avoid integer overflow
            return 99999;
        }

        int case1 = 0 + helper(coins, idx + 1, amount);

        int case2 = 1 + helper(coins, idx, amount - coins[idx]);

        return Math.min(case1, case2);
    }
}
