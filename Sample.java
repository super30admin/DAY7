// Time Complexity :O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
       int m=coins.length;
        int n=amount;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=amount+1;
        }
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(j<coins[i-1])
                    dp[j]=dp[j];
                else
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
            }
        int res=dp[n];
        if(res>=amount+1){
            return -1;
        }
        return res;
    }
}

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        // Approach:
        // 1. DP-> An array which checks if the money collected from two house position before is greater than the sum of money collected from a previous house position's calculation.
        // 2. Return the maximum of last two positions as those will be having maximums of calculated money values.
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);        
    }
}