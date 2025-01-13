// Time complexity:- O(n) 
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially, I had difficulty understanding the approach, 
// but after watching Raj Sir's video, I understood it.


// Your code here along with comments explaining your approach
/**
 * Approach: 
 *  The problem is to get as much money as possible by robbing houses on a street, 
 *  but you can't rob two houses next to each other because of security alarms. I have used the approach dynamic programming 
 *  to track two possibilities for each house: rob the house or not rob the house. I calculated the maximum money we can have 
 *  based on weather we rob the house or not rob the house, considering the privious house's choices. The final result is the 
 *  maximum of robbing or not robbing the last house.
 * 
 */ 
class Solution {
    public int rob(int[] nums) {

        // if the input is null or empty return 0
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // Not robbing the first house
        dp[0][1] = nums[0]; // Robbing the first house

        for(int i = 1; i < n; i++) {
            
            // If we don't rob the current house, take the maximum from either robbing or not robbing the previous house
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // If we rob the current house, we add its value to the maximum from not robbing the previous house
            dp[i][1] = dp[i - 1][0] + nums[i];

        }

        // Return the maximum profit by either robbing or not robbing the last house
        return Math.max(dp[n -1][0],dp[n -1][1]);
    }
}