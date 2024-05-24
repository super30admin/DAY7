/***
Approach-
*1. Create a 1D matrix and initialize index=0 with cost=0 and index=1 with cost = max(dp[0],nums[0])
*2. Start with index=2 and calculate the max cost between - rob current house or don't rob current house
*3. If we rob current house, then cost = dp[i-2] + cost[index-1], if we don't rob current house, then cost = dp[i-1]
 * TC- O(n), SC- O(n)
***/

class Solution {
    //TC - O(n)
    //SC- O(n)

    public int rob(int[] nums) {

        //Edge case
        if(nums == null || nums.length == 0)
            return 0;

        //Using DP and 1D matrix
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = Math.max(dp[0], nums[0]);

        for(int i =2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];

    }
}