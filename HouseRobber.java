// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0||nums == null){
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i<nums.length;  i++){
            dp[i][0]  = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]  = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0] , dp[n-1][1]);
    }
}