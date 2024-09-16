//o(n*m) space and time complexities
//passed all leetcode cases
// used approach discussed in class

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;

        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 9999;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] +1);
            }
        }
        if(dp[dp.length-1][dp[0].length-1] >=9999) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
}