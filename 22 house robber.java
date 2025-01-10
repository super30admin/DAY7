// Time Complexity : O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //aesha
    public int rob(int[] nums) {
        int n=nums.length;
        if(nums == null || n == 0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
       
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int i=2; i<n; i++)
        {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}