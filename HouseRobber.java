// Time Complexity : O(n) n is the no of elements
// Space Complexity : O(n) extra step for memorisation table
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
At each step, the robber has two options.
If he chooses to rob the current house,
he will have to skip the next house on the list by moving two steps forward.
If he chooses not to rob the current house,
he can simply move on to the next house in the list. Let's see this mathematically.

robFrom(i)=max(robFrom(i+1),robFrom(i+2)+nums(i))
 */

// Your code here along with comments explaining your approach
class HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;

        int dp[]=new int[n+1];

        dp[n]=0;
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);
        }

        return dp[0];
    }
}