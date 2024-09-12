class HouseRobber {

    //Brute force approach- Recursive approach
    //T.C = 0(2^n)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }
    public int helper(int[] nums, int index, int totalsum){
        if(index >= nums.length){
            return totalsum;
        }
        //case 1 when we rob the house
        int case1 = helper(nums, index + 2, totalsum + nums[index]);
        //case 0 or when no house is selected
        int case0 = helper(nums, index + 1, totalsum);
        return Math.max(case1, case0);
    }
}

//Optimised approach using DP
// Time Complexity : 0(n) where n is the length of the array
// Space Complexity : 0 (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I took two variables skip and take. Skip defines if the robber
//didn't rob the house and take defines if he chose to rob the particular house. When the robber skips the house, he has an
//option of all the other houses available to rob the house. But if he plans to rob the house, then he can't rob adjacent
//houses.Hence, I am assuming a virtual array in which 2 conditions are stored where in skip resembles the maximum value
//that can be attained by skipping the house and robbig others, whereas take resembles the sum of skip and the current house
//as the robber plans to rob the current house. Hence, at the end, I return the maximum value between skip and take.


class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int skip = 0;
        int take = 0;
        for(int i = 0; i< nums.length; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = nums[i] + temp;
        }
        return Math.max(skip, take);
    }
}