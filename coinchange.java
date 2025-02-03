// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

class coinchange{
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int [m+1] [n+1];

        for(int i = 0; i <= n; i++){
            dp[0][i] = 999999;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j<= n; j++){
            // till denomination of coin < amt
                if(coins[i-1] > j){
                    //0 case
                    dp[i][j] = dp[i-1][j];
                }else{
                    //1 case
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
        }
        }
        int re = dp[m][n];
        if(re >= 999999) return -1;
        return re;
    }
}