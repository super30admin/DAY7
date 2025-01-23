// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No, but there is a way to solve this using 1D dp array which i need to study
public class CoinChangeI {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return -1;
        int MAX = amount+1;
        int[][] dp = new int[coins.length+1][amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[0][i] = MAX;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[coins.length][amount] == MAX ? -1 : dp[coins.length][amount];
    }
}
