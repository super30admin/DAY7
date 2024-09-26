// S30 Big N Problem #19 {Medium}
// 322. Coin Change
// Time Complexity : O(m*n) {m*n target v/s coins matrix}
// Space Complexity : m*n elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Dp matrix; avoiding repetition in sub-problem
// move the coins[index] back in the row and add 1 to it; fill it with the min of the previous and the current value.
//coins target 0 1 2 3 4 5 6 7 8
//0            inf................
//1            0 1 2 3 4 5 6 7 8
//2            0 1 1 2 2 3 3 4 4
//5            0 1 1 2 2 1 2 2 3-> answer
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [][]dp=new int[coins.length+1][amount+1];
        int m=dp.length;
        int n=dp[0].length;
        
        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }
        
        for(int i=0;i<n;i++){
            dp[0][i]=9999;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        int result=dp[m-1][n-1];
        if(result==9999) return -1;
        else return result;
          
    }
}