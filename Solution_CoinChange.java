//TC:O(mxn)
//SC:O(mxn)
//Did it run on leetcode: Yes

public class Solution_CoinChange {

    // public int minCoins(int[] coins, int ind, int amt){
    //     if(amt == 0)
    //         return 0;
    //     if(amt < 0 || ind == coins.length)
    //         return 99999;
    //     int case1 = minCoins(coins, ind+1, amt);
    //     int case2 = 1 + minCoins(coins, ind, amt - coins[ind]);
    //     return Math.min(case1, case2);
    // }

    public int coinChange(int[] coins, int amount) {
        // int ans = minCoins(coins, 0, amount);
        // return ans >= 99999 ? -1 : ans;

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        for(int c = 1; c <= n; c++)
            dp[0][c] = 99999;

        for(int r = 1; r <= m; r++){
            for(int c = 1; c <= n; c++){
                if(coins[r-1] > c)
                    dp[r][c] = dp[r-1][c];
                else
                    dp[r][c] = Math.min(dp[r-1][c], 1 + dp[r][c - coins[r-1]]);
            }
        }
        return dp[m][n] >= 99999 ? -1 : dp[m][n];
    }
}
