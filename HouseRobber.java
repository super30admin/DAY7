class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int index, int max) {
        int skip = 0;
        int take = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + nums[i];
        }
        return Math.max(skip,take);

    }
}