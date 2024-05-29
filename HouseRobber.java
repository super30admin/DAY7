//Time Complexity - O(n)
//Space Complexity - O(1)
// Leetcode - Yes
//Approach - Maintain two variables skip and take. This indicates whether an element should be skipped or taken. 
// If we skip the current element, the maximum amount robbed can be found be obtaining max between skip and label. 
// If we take the current element, then we cannot take the previous element strictly. 
class Solution {
    public int rob(int[] nums) {

        int skip = 0; 
        int take = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int tempSkip = skip;
            skip = Math.max(skip,take);
            take = tempSkip + nums[i];
        }

        return Math.max(skip, take);
        }
}
        // //DP solution

        // int[][] dp = new int[nums.length][2];

        // dp[0][0] = 0;
        // dp[0][1] = nums[0];

        // for(int i = 1; i < nums.length; i++){
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        //     dp[i][1] = nums[i] + dp[i-1][0];
        // }

        // return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

        
        

