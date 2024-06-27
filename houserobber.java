// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        int max1=0;
        int max2=0;
        
        for (int i=0;i<nums.length;i++){
            int temp = Math.max(nums[i]+max1,max2);  
            max1=max2;
            max2=temp;

        }
        return max2;
    }
}