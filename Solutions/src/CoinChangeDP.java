// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        int dp[][]= new int[coins.length+1][amount+1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i=0;i<m;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<n;j++){
            dp[0][j]=9999;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result = dp[m-1][n-1];
        if(result>=9999) return -1;
        else{
            return result;
        }
    }

}
