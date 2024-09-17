// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;
public class Robbery {
    private int rec(int ind,int []nums,int []dp){
        if(ind<0) return 0;
        if(ind==0) return nums[0];
        if(dp[ind]!=-1) return dp[ind];
        int pick = nums[ind] + rec(ind-2,nums,dp);
        int notpick = 0 + rec(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return rec(nums.length-1,nums,dp);
    }
}
