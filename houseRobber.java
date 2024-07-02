// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach: 
 * Using DP: It initializes an array dp where dp[i] represents the maximum money that can be robbed up to house i.
 *  By iterating through each house and deciding whether to rob it based on previously calculated optimal solutions 
 * (dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1])), 
 * it calculates the maximum possible robbery amount.
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0 || nums==null)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];// for house 0, we can only rob house 0
        dp[1]=Math.max(nums[0],nums[1]);  // for house 1, we can rob just house 1 or just house 0, we take the max
        for(int i=2; i<dp.length; i++)
        {
        // at house i, we could rob it or not rob it
        // if we rob house i (current house), we know that
        // our previously robbed house would be i - 2 since
        // we can not rob adjacient house
        // if we do not rob house i (current house), we know that
        // our previously robbed house would be i - 1 for the same 
        // reason 
        
        // so the current accumulated sum at house i will be the max 
        // of the two cases except if we rob, make sure
        // we add the money in current house first before comparing
        // so,
        // if choose to rob, the money will become: dp[i-2] + nums[i]
        // if choose not to rob, the money will become: dp[i-1]
        // dp[i]: robbed so far
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}