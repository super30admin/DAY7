// Time Complexity : O(2^n) --> where is the length of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (198): Yes
// Any problem you faced while coding this : No

// Explaination: In this 'House Robber' problem, we are recursively iterating over each possibility to get the maximum amount of robbing the house. In each iteration we have 2 choices i.e. (1) chhose to rob the house and (2) not to rob the house. If we consider choice 1 then the amount will get increased by the particular stashed amount in the house and the index will get increase by 2 as no adjacent house can be robbed. And if we consider choice 2 then the amount will remain the same but the index is increased by 1. Going with this recurrsion approach, there will be multiple similar sub-cases that we will have to compute each and every time and so this is not a good approach to solve this kind of problems. Hence, its time complexity will be exponential.

// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;      
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount) {
        // base case
        if (index >= nums.length) return amount;
        
        // logic
        // choose
        int case1 = helper(nums, index + 2, amount + nums[index]);
            
        //don't choose
        int case2 = helper(nums, index + 1, amount);
        
        return Math.max(case1, case2);
    }
}