// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int c = nums[0];
        int nc = 0;
        for(int i = 1;i<nums.length;i++){
            int temp = c;
            c = nc + nums[i];
            nc = Math.max(temp, nc);
        }
        return Math.max(c,nc);
    }
}