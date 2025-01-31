// Overall Time Complexity : O(m*n) . The m*n is number of elements in the matrix.
// Overall Space Complexity : O(m*n) . The space complexity is the size of the matrix.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem invloves finding the minimum coins needed to make the target amount.
// Iterate over each coin and update the dp table by considering including or excluding the coin.
// If the value for the target amount is still large (99999), return -1 (impossible to make the amount).


class Solution {
   
    public int coinChange(int[] coins, int amount) {

        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];

        for(int j = 1; j<=n; j++){
            dp[0][j] = 99999;
        }
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                // do until denomination of coins < amount
                if(coins[i-1]>j){
                    //Oth case of not choosing the coin
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    // 0 and 1 case of choosing the coin
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }

            }
        }
        int re = dp[m][n];
        if(re>=99999){
            return -1;
        } 
        return re;
      


       }
    }