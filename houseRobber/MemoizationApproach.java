package houseRobber;

//top down approach
// non-dp approach

// Time Complexity : O(n)
// Space Complexity : the space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.Arrays;

public class MemoizationApproach {

    private static int[] memo;

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};

        memo= new int[nums.length];
        Arrays.fill(memo, -1);

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        return helper(nums, 0);
    }

    private static int helper(int[] nums, int idx) {

        // base
        if(idx >= nums.length) {
            return 0;
        }

        if(memo[idx] != -1) {
            return memo[idx];
        }

        int case1 = nums[idx] + helper(nums, idx + 2);

        int case2 = helper(nums, idx + 1);
        int result = Math.max(case1, case2);

        memo[idx] = result;

        return result;
    }
}
