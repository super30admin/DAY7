//TC: O(m*n) -> m=number of coins, n=total amount
//SC: O(n)
//Approach: dp[i][j] represents minimum number of coins required for first i coins and remaining j amount. Max number of coins would be amount in this case as min coin value is 1. We take 1 coin first, find min coins required and increment the number of coins used one by one. 

class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int nCoins = coins.length; int n = amount;
        int[] dp = new int[n+1];

        for(int j=1;j<=n;j++) dp[j] = amount +1;

        for(int i=1;i<=nCoins;i++){
            for(int j =1;j<=n;j++){
                if(j < coins[i-1])
                    continue;
                else
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
            }
        }

        if(dp[n] > amount) return -1;

        return dp[n]; 
    }

    public int coinChange2DArraySolution(int[] coins, int amount) {
        int nCoins = coins.length; int n = amount;
        int[][] dp = new int[nCoins+1][n+1];

        for(int j=0;j<=n;j++) dp[0][j] = amount +1;

        for(int i=1;i<=nCoins;i++){
            for(int j =1;j<=n;j++){
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
            }
        }

        if(dp[nCoins][n] > amount) return -1;

        return dp[nCoins][n]; 
    }
}