// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// (https://leetcode.com/problems/house-robber/)
// Algo:

import java.util.Arrays;

/**
 * Greedy Approach:
 * A. Pick Max and skip alternate
 * Fail Case 1: [1, 3, 1, 1, 1, 1, 9] amount = 12
 * 1 + 1 + 1 + 9 = 12
 * 
 * ----------------------------------
 * 
 * best possible answer = 13
 * 3 + 1 + 9 = 13
 * 
 * Hence, Greedy fails.
 * So, go exhaustive and explore all possible solutions using recursion.
 */
public class HouseRobber_LC_198 {

    /**
     * TC: exponential
     * SC: O(n)
     * 
     * @param nums
     * @return
     */
    public int rob_recursion(int[] nums) {
        int n = nums.length;
        return rob_recursion(n - 1, nums);
    }

    public int rob_recursion(int index, int[] nums) {
        // base
        if (index == 1) {
            return Math.max(nums[1], nums[0]);
        }
        if (index == 0) {
            return nums[index];
        }
        // logic
        int pick = nums[index] + rob_recursion(index - 2, nums);
        int notPick = rob_recursion(index - 1, nums);
        return Math.max(pick, notPick);
    }

    /**
     * TC: O(N)
     * SC: O(2n)
     * 
     * @param nums
     * @return
     */
    public int rob_memoize(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rob_memoize(n - 1, dp, nums);
    }

    public int rob_memoize(int index, int[] dp, int[] nums) {
        // base
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == 1) {
            return dp[index] = Math.max(nums[1], nums[0]);
        }
        if (index == 0) {
            return dp[index] = nums[index];
        }
        // logic
        int pick = nums[index] + rob_memoize(index - 2, dp, nums);
        int notPick = rob_memoize(index - 1, dp, nums);
        return dp[index] = Math.max(pick, notPick);
    }

    /**
     * TC: O(N)
     * SC: O(n)
     * 
     * @param nums
     * @return
     */
    public int rob_tabulation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int index = 2; index < n; index++) {
            int pick = nums[index] + dp[index - 2];
            int notPick = dp[index - 1];
            dp[index] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    public int rob_spaceOptimization(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int prev2 = nums[0];
        int prev = Math.max(nums[1], nums[0]);
        for (int index = 2; index < n; index++) {
            int pick = nums[index] + prev2;
            int notPick = prev;
            prev2 = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }

}
