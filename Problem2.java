// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) where n is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We are using a memoization approach to solve this problem. We are iterating over the houses and checking if the current house is robbed or not. If the current house is robbed, then we are adding the amount at the current house and the amount at the house 2 steps back. If the current house is not robbed, then we are taking the amount at the house 1 step back. We are returning the maximum of the two cases. We are using a memoization array to store the values at each index. If the value is already present in the memo array, then we are returning the value from the memo array. If the index is greater than or equal to the length of the array, then we are returning 0. We are returning the result from the helper function. If the input array is null or empty, then we are returning 0.

import java.util.Arrays;

class Problem2 {
    int[] memo;
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int idx){
        //base
        if(idx >= nums.length){
            return 0;
        }
        if(memo[idx] != -1){
            return memo[idx];
        }

        // logic
        int case1 = helper(nums, idx+1);
        int case2 = nums[idx] + helper(nums, idx+2);

        int res = Math.max(case1, case2);

        memo[idx] = res;
        return res;
    }
}