// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0 || nums == null ) return 0;
       
       
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i=1;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
        // return helper(nums, 0, 0, dp);
        
    }
    
//     private int helper(int[] nums, int sum, int index) {
//         if(index >= nums.length) return sum; 
        
//         // case 1: don't choose
//         int left = helper(nums, sum, index+1);
//         // case 2: choose
//         int right = helper(nums, sum + nums[index], index + 2);
        
//         return Math.max(left, right);
//     }
}
