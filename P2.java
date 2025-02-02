// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Top-down or Memoization

import java.util.Arrays;

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        this.memo = new int [nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private int helper(int[] nums, int indx) {
        // base case
        if (indx >= nums.length) return 0;
        if(memo[indx] != -1) return memo[indx];
        //logic
        //choose to rob the house
        int case1 = nums[indx] + helper(nums, indx + 2);

        //dont choose
        int case2 = helper(nums, indx + 1);
        int re =  Math.max(case1, case2);
        memo[indx] = re;
        return re;
    }
}


//Bottom up or Tabular
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        if (n == 1) return dp[0];
        dp[1] = Math.max(dp[0], nums[1] + 0);
        for(int i = 2; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}

//SC optimisation - O(1)
public int rob(int[] nums) {
    int n = nums.length;
    //int[] dp = new int[nums.length];
    int prev = nums[0];

    if (n == 1) return prev;
    int curr = Math.max(nums[0], nums[1] + 0);
    for(int i = 2; i < n; i ++) {
        int temp = curr;
        curr = Math.max(curr, nums[i] + prev);
        prev = temp;
    }
    return curr;
}
