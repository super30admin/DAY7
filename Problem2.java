// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        // return helper(nums, 0);
        // int dp[] = new int[nums.length];
        int prev = nums[0];
        int cur = Math.max(nums[0], nums[1] + 0);
        for(int i = 2; i < nums.length;i ++){
            int temp = cur;
            cur = Math.max(cur, prev + nums[i]);
            prev = temp;
        }

        return cur;
    }
}