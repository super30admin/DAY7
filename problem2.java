//Problem1 (https://leetcode.com/problems/coin-change/)
// Time Complexity : o(n)
// Space Complexity :  o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class problem2 {
    public int rob(int[] nums) {
        int n =nums.length;
        if(n==1)
        {
            return nums[0];
        }
        int[] dp= new int[n];
        dp[0]=  nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]= Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
//
