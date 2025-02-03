//The approach is to optimize the exhaustive solution by storing the previously solved answers in a table
//Time Complexity: O(m*n) where m is the no. of coins and n is the amount
//Space Complexity: O(m*n) where m is the no. of coins and n is the amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int re;
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j<=n; j++){ // j starts from one because dp[0][0] is 0 by default
            dp[0][j] = 99999;
        }
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){ //j starts from 1 because for j = 0, the dp[i][j] is by default 0, as arrays initialize with 0 by default
                //till denomination of a coin < amount
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        re = dp[m][n];
        if(re>=99999){
            return -1;
        }
        return re;
    }

}
