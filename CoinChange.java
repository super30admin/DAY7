// Time Complexity :o(n*m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i= 1;i<dp[0].length;i++){
            dp[0][i] = 9999;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j - coins[i-1]]+1);                
                }
            }
        }   
        int result =dp[dp.length-1][dp[0].length-1];
        if(result>=9999)return -1;
        return result;
    }
}