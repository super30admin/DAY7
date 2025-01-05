/************************* PROBLEM -1 *************************/

// Time Complexity : 0(n*m)
// Space Complexity : o(n*m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


//Intuition is to create a matrix with all possible combinations to store solution
// and use the already stored solution to solve the existing combination.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins==null){
            return -1;
        }
        int max=amount+1;//infinity
        int[][] dp=new int[coins.length+1][amount+1];
        for(int j=1;j<=amount;j++){
            dp[0][j]=max;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }

        }
        if(dp[coins.length][amount]==max){
            return -1;
        }
        return dp[coins.length][amount];
    }
}