class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp=new int[coins.length+1][amount+1];
        int n=coins.length;
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }
        for(int j=1;j<=amount;j++)
            dp[0][j]=9999;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }
        }
        if(dp[n][amount]==9999)
            return -1;
        else
            return dp[n][amount];
    }
}

// Time Complexity: O(n*k), n=no of elements, k=target
// Space Complexity: O(n*k)