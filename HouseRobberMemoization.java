// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively calculate the maximum amount of money that can be robbed, and store the
// intermediate results in a memo array to avoid repeated calculations.

public class HouseRobberMemoization {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int idx) {
        // base
        if (idx >= nums.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        // choose
        int case1 = nums[idx] + helper(nums, idx + 2);
        //don't choose
        int case2 = helper(nums, idx + 1);
        int re = Math.max(case1, case2);
        memo[idx] = re;
        return re;
    }
}
