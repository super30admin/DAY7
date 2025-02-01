public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = amount+1;
        }
      for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        if (dp[n] >= amount+1)
            return -1;
        else return dp[n];
    }
    public static void main(String[] args){
        int[] arr=new int[]{1,2,5};
        CoinChange coinChange=new CoinChange();
        coinChange.coinChange(arr,11);
    }
}

/*
public int coinChange(int[] coins, int amount) {
    int m=coins.length;
    int n=amount;
    int[][] dp=new int[m+1][n+1];
    for(int i = 0; i <= coins.length; i++){
        dp[i][0] = 0;
    }
    for(int j=0;j<=n;j++){
        dp[0][j]=99999;
    }
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(coins[i-1]>j){
                dp[i][j]=dp[i-1][j];
            }else{
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
    }
    if(dp[m][n]>99999)
        return -1;
    else return dp[m][n];
}
*/

/*
public int coinChange(int[] coins, int amount) {
    int result= helper(coins,0,amount);
    if(result>=99999)return -1;
    return result;
}
public int helper(int[] coins,int idx,int amount){
    if(amount==0) return 0;
    if(amount< 0 || idx==coins.length) return 99999;
    int case1= 0+helper(coins,idx+1,amount);
    int case2=1+helper(coins,idx,amount-coins[idx]);
    return Math.min(case1,case2);
}*/
