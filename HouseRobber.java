// Time Complexity : O(N)
// Space Complexity : O(1) as we don't need to track more than 2 house away
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0]; // rob it as it is only one
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        // Either we don't rob this house and take home up to it's left neighbor; 
        // or we don't rob its left neighbor but do rob this house
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}