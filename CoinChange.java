class Solution {
    
    public int coinChange(int[] coins, int amount) {
          int n= amount;
          int m= coins.length;
        int dp[] = new int[amount+1];
        for(int i=1;i<=n;i++)
          dp[i]=amount+1;
        for(int i=1;i<=m;i++){
        for(int j=0;j<=n;j++){
          if(j>=coins[i-1])
            dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
        }
        }
        if(dp[n]==amount+1)
         return -1;
         else
        return dp[n];
    }
}