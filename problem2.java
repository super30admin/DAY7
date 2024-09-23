// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nopw


class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int prev = nums[0];
        int current = Math.max(prev, 0 + nums[1]);
        for(int i =2; i<nums.length; i++){
            int temp = current;
            current = Math.max(current, nums[i] + prev);
            prev = temp;
        }
        return current;
    }
}