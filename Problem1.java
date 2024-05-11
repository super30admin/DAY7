//TC : O(mn)
// SC: O(mn)
public class Problem1{
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        for (int j=1;j<=n;j++){
            dp[j]=amount+1;
        } 

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(j<coins[i-1]){
                    dp[j] = dp[j];
                }
                else{
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[n]>=amount+1) return -1;
        else return dp[n];
    }
}