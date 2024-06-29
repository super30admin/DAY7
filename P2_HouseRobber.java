// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length ; i++) {
            int temp = curr;
            curr = Math.max(nums[i] + prev, curr);
            prev = temp;
        }
        return curr;
    }
}   