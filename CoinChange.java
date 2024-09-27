class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=1;i<=coins.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<=amount;i++)
        {
            dp[0][i]=9999;
        }
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1]) { dp[i][j]=dp[i-1][j];}
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result=dp[coins.length][amount];
        if(result== 9999) return -1;
        return result;
    }
    
}