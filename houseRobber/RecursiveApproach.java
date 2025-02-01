package houseRobber;

//top down approach
// non-dp approach

// Time Complexity : logrithmic Thus, the worst-case time complexity is O(2^n) where n is the number of houses
// Space Complexity : the space complexity is O(n) due to recursive stack usage.
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time limit exceeded exception

public class RecursiveApproach {

    public static void main(String[] args) {

//        int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};

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

        // logic

        // choose
        int case1 = nums[idx] + helper(nums, idx + 2);

        // dont choose
        int case2 = helper(nums, idx + 1);

        return Math.max(case1, case2);
    }
}
