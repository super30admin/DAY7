// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* each subproblem has two cases, if we choose to rob the current house( we cant rob the next house) or we choose not to rob the current house,
 we build upon the maximum amount that can be robbed at each increasing subset of the houses for both cases.
  The final value (when you reach the last house) gives us the max amount robbed. 
*/

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==0) return 0;
        if(n==1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);

        }

        return dp[n-1];
        
    }
}