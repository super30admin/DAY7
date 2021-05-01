class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) return 0;
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int res = dp[dp.length-1][dp[0].length-1];
        if(res>=amount+1) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}
