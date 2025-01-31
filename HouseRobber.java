// Overall Time Complexity : O(n) . The n is number of house in the array.
// Overall Space Complexity : O(n) . The space complexity is the size of the dp array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem invloves finding the maximum loot that can be stolen up to each house, either by skipping or robbing the current one.
// Iterate over the houses, by updating the maximum amount and  considering the best option at each step either we skip or rob the house.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        if(n==0) return 0;
        if(n==1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<n;i++){
            dp[i] = Math.max(dp[i-1], (dp[i-2]+nums[i]));
        }


        return dp[n-1];
    }
}