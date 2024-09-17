// Time Complexity: O(n)
// Space Complexity: O(length of nums)
class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return rob(nums, dp, nums.length-1);
    }

    public int rob(int[] nums, int[] dp, int i) {
        if(i<0) {
            return 0;
        }

        if(dp[i]>=0) {
            return dp[i];
        }

        int res = Math.max(rob(nums,dp,i-2)+nums[i], rob(nums,dp, i-1));
        dp[i] = res;
        return res;
    }
}