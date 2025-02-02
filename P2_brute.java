// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] nums, int indx) {
        // base case
        if (indx >= nums.length) return 0;
        //logic
        //choose to rob the house
        int case1 = nums[indx] + helper(nums, indx + 2);

        //dont choose
        int case2 = helper(nums, indx + 1);
        
        return Math.max(case1, case2);
    }
}
