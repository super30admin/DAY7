class Solution {
    // Time Complexity : O(n) where  n is the number of houses
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Nope
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev = 0;
        int curr = 0;
        for(int x: nums) {
            //include and exclude criteria
            int t = curr;
            curr = Math.max(prev + x , curr);
            prev = t;
        }
        return curr;
    }
}
