class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        return recurse(coins, amount, 0, 0);
    }

    private int recurse(int[] coins, int amount, int index, int coinsUsed) {
        // base
        // if(index == coins.length || amount < 0) {
        //     return -1;
        // }
        // if(amount == 0) {
        //     return coinsUsed;
        // }

        // // logic
        // // zero or do not choose the coin case
        // int case1 = recurse(coins, amount, index + 1, coinsUsed);
        // // one or choose the coin case
        // int case2 = recurse(coins, amount - coins[index], index, coinsUsed + 1);
        // if(case1 == -1) { 
        // // as if we take min of -1 and anohther number then it would return -1, 
        // // thus we do not want that
        //     return case2;
        // }
        // if(case2 == -1) {
        //     return case1;
        // }
        // return Math.min(case1, case2);


        if(coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        // very large no would be amount + 1 as it will never be more than that
        for(int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) { // zero case
                    dp[i][j] = dp[i - 1][j];
                } else { // 1 case
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}
