// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I need to study better on how to calc what values form my output
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        
        int[][] dp = new int[nums.length+1][2];
        for(int i=1;i<=nums.length;i++){
            dp[i][0] = Math.max(dp[1-1][0],dp[i-1][1]);
            dp[i][1] = nums[i-1] + (i - 2 >= 0 ? Math.max(dp[i-2][0], dp[i-2][1]) : 0);
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    } 
}
