//322. Coin Change - https://leetcode.com/problems/coin-change/description/
//Time Complexity: Exponential Time Complexity O(2^(m+n)) where m: number of elements, n: amount

//Recurrsion Approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0,0);
    }

    private int helper(int[] coins, int amount, int index, int coinsUsed){
        //base case
        if(amount < 0 || index == coins.length){
            return -1;
        }
        //happy path
        if(amount == 0){
            return coinsUsed;
        }
        //choose coin
        int case1 = helper(coins, amount - coins[index], index, coinsUsed + 1);
        //don't choose coin
        int case2 = helper(coins, amount, index + 1, coinsUsed);
        if(case1 == -1){
            return case2;
        } else if(case2 == -1){
            return case1;
        }
        return Math.min(case1, case2);
    }
}

//DP Approach
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];

        for(int j=1; j<=n; j++){
            dp[0][j] = 99999;
        }

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){ //no choose case
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1); //choose case
                }
            }
        }
        //if amount can't be reached, return -1
        if(dp[m][n] >= 99999){
            return -1;
        }
        //last element of the matrix
        return dp[m][n];
    }
}

//DP Approach (Optimized Space Complexity using 1D Array)
//Time Complexity: O(m*n)
//Space Complexity: O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [] dp = new int[n+1];

        for(int j=1; j<=n; j++){
            dp[j] = 99999;
        }

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){ //not choose case
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - coins[i-1]] + 1); //choose case
                }
            }
        }
        //if amount can't be reached, return -1
        if(dp[n] >= 99999){
            return -1;
        }
        //last element of the matrix
        return dp[n];
    }
}