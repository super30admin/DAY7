class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        int n = coins.length, m = amount;
        int[][] dp = new int[n+1][m+1]; //+1 is for the dummy row
        //for the first row
        for(int j = 1; j<=m; j++){
            dp[0][j] = 999999; //infinity
        }

        for (int i = 1; i< dp.length; i++){
            for(int j = 1;j< dp[0].length; j++){
                if(j < coins[i-1]){
                    //case0
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] +1);
                }
            }
        }
        if(dp[n][m] >= 999999) return -1;
        return dp[n][m];
    }
}