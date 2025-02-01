package houseRobber;


// Time Complexity : O(n)
// Space Complexity : the space complexity is O(n) due to recursive stack usage.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DPApproach {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        if (n == 1) {
            return dp[0];
        }

        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n-1];
    }
}
