// Time Complexity : O(n) --> where is the length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (198): Yes
// Any problem you faced while coding this : No

// Explaination: In this 'House Robber' problem, we are just iterating over the the array to compute 2 things: the amount when the house is chosen and the amount when house is not chosen. In each iterating we are maintaining 2 amount and storing only the latest values. In this way we are eliminating the computation of similar sub-cases (like we had in using recurssion method). At the end, we just take maximum amount between the two amount. Going with this method, we are able to solve the problem in linear time i.e. O(n).


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;      
        int skip = 0;
        int take = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        
        return Math.max(skip, take);
    }
}