/ Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// Use two variables: skip for the maximum money if you don't rob the current house, and take for the maximum money if you do rob it.
// For each house, update skip to the max value of skip or take from the previous house, and update take to skip from
// the previous house plus the current house's money. After processing all houses, the maximum money you can rob is the higher value between skip and take.

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int skip = 0;
        int take = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = skip;
            skip = Math.max(temp, take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
}