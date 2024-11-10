/*
    Time Complexity : O(n) n is the number of houses

    Space Complexity : O(n)

    Did this code successfully run on Leetcode : Yes
 */
class HouseRobberDPArray {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n==1) return nums[0]; //if we have only 1 house

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<n; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[n-1];
    }
}