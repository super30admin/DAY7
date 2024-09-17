// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0)
            return 0;
         int dp[][]= new int[coins.length+1][amount+1];
             for(int i=1;i<dp[0].length;i++)
             {
                 dp[0][i]=9999;
             }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
              if(j<coins[i-1])
              {
                  dp[i][j]=dp[i-1][j];
              }
                else
                   dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
        int result =dp[dp.length-1][dp[0].length-1];
        if(result>=9999)
            return -1;
        else
            return result;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------
//House Robber 
// Time Complexity :O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[][] dp=new int[nums.length][2];
        int n=nums.length;
        dp[0][1]=nums[0];
        for(int i=1;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}