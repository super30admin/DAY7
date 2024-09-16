//Time Complexity: O(n)
//Space Complexity: O(1)
//LeetCode : Yes

//Use tabulation. Initialise a 2D array as the table has to be filled with no of coins and the denominations. 
//Find the pattern between the current entry and the previous entries. 
//Last entry will be the required no of coins

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i =0; i< amount +1; i++){
            dp[0][i] = 9999;
        }
        
        for(int i =0;i<coins.length+1; i++){
            dp[i][0] = 0;
        }
        
        for(int i =1; i< amount +1; i++){
            for(int j =1; j< coins.length +1; i++){
                if(j<dp[i][j]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                     }
                
        }
    }
        return dp[coins.length][amount];
}