// Time Complexity :O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach:

1) create a matrix to store amounts as columns and amounts as rows 
2) store the amount by calculating the matrix values by moving pointers i and j.


*/

class Solution {
    public int coinChange(int[] coins, int amount) {
       
        
        if(coins==null || coins.length ==0)
        {
            return -1;
        }
        
        int dp[][]= new int[coins.length+1][amount+1];
        
        for(int i=1;i<amount+1;i++)
        {
            dp[0][i]=amount+1;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]= dp[i-1][j];
                }
                else
                {
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
                                                        
        int result = dp[dp.length-1][dp[0].length-1];
        if(result==amount+1)
                return -1;
        return result;
    }
}