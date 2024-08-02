//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class CoinChange {

    public static int coin(int[] coins, int amount){
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int j=1;j<=n;j++){
            dp[0][j]=99999;
        }
        for(int i = 1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j < coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]>=99999){
            return -1;
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int result = coin(coins, amount);
        System.out.println("The coin change for amount 11 is: " + result);
    }
}
