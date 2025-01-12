// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// // used the tabulation approach by creating a 2d array based on number of houses and options to either rob or not rob the house

public class HouseRobber {
        public int rob(int[] nums) {
            if(nums == null || nums.length ==0){
                return -1;
            }
            int n = nums.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = nums[0];
            for(int i=1;i<nums.length;i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = dp[i-1][0] + nums[i];
            }
            return Math.max(dp[n-1][0], dp[n-1][1]);
        }
}
