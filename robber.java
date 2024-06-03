// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return - 1;
        }
        int [][] dp = new int[nums.length][2]; // 2 columns - choose the house and not choose the house
        dp[0][0] = 0; // first house, not to choose so amount is 0
        dp[0][1] = nums[0]; // first house, choose and total amount is amount
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); // maximum of above row's cols
            dp[i][1] = nums[i] + dp[i-1][0]; // sum of current amount and not chosen above amount
        }

        return Math.max(dp[nums.length-1][1], dp[nums.length-1][0]);
    }
}