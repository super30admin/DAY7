/*
    LC - 198. House Robber
    TC - O(n * 2) ~ O(n)
    SC - O(n * 2) ~ O(n)
    Approach - 
        using bottom up approach, with skip & take logic by keeping the maximum rob value.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

/*
    LC - 198. House Robber
    TC - O(n * 2) ~ O(n)
    SC - O(1)
*/
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int skip = 0, take = nums[0];
        for(int i=1; i < nums.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }
}