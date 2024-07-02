/*
    1. Time Complexity : O(n) - n - number of houses
    2. Space Complexity : O(n), Tabulation - O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

import java.util.Arrays;
class Solution {
    static int[] dp;
    public static int helper(int[] nums, int idx) {
        if(idx>=nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        dp[idx] = Math.max(helper(nums, idx+1), nums[idx] + helper(nums, idx+2));
        return dp[idx];
    }
    public static int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; ++i)
            dp[i+2] = Math.max(nums[i] + dp[i], dp[i+1]);
        return Math.max(dp[n], dp[n+1]);
    }
    public static int rob3(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        int prev=nums[0], curr=Math.max(prev, nums[1]), temp;
        for (int i = 2; i < n; ++i) {
            temp = curr;
            curr = Math.max(curr, nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println("Using Memoisation -- Max amount robbed is:"+rob(nums));
        System.out.println("Using Tabulation -- Max amount robbed is:"+rob2(nums));
        System.out.println("Using Tabulation with O(1) space -- Max amount robbed is:"+rob3(nums));
    }
}
