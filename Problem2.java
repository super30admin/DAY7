/*Exhaustive Approach*/

/* Time Complexity : O(2^N)
 Space Complexity :O(N)[Call Stack]
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */

/*
class Solution2{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int idx, int amt){
//        base
        if(idx >= nums.length) return amt;
//        logic
//        Case 0:
        int case0 = helper(nums, idx+1, amt);
//        Case1:
        int case1 = helper(nums, idx + 2, amt + nums[idx]);
        return Math.max(case0, case1);
    }
}
*/

/* 1-D DP approach
Time Complexity : O(N)
 Space Complexity :O(N)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */

/*class Solution2 {
    public int rob(int[] nums){
        // null check
        if(nums==null||nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        // default case
        dp[0] = nums[0];

        for(int i = 1; i < dp.length; i++){
            if(i == 1){
                dp[i] = Math.max(dp[i-1], nums[i]);
            }
            else{
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }

        return dp[nums.length - 1];
    }
}*/

/* 1D DP with in-place substitution of i/p array.
Time Complexity : O(n)
 Space Complexity :O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */

class Problem2 {

    public int rob(int[] nums){
        // null check
        if(nums==null||nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i == 1){
                nums[i] = Math.max(nums[i-1], nums[i]);
            }
            else{
                // int temp = nums[i];
                nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]);
            }
        }

        return nums[nums.length - 1];
    }
}

/*Some other tries...*/

/* public int rob(int[] nums) {
     // null check
     if(nums == null || nums.length == 0) return -1;
     int n = nums.length;
     int[] dp = new int[n+1];
     for(int i = 0; i < n; i++){
         // choose case
         if(i == 0){
             dp[i+1] = nums[i];
         }
         else{
             dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
         }
     }
     return dp[n];
 }
 public int rob(int[] nums) {
     // Null check
     if(nums == null || nums.length == 0) return -1;
     int len = nums.length;
     if(len == 1) return nums[0];
     int twoStepsBack = nums[0];
     int oneStepBack = Math.max(nums[0], nums[1]);
     for(int i = 2; i < len; i++){
         int temp = oneStepBack;
         oneStepBack = Math.max(oneStepBack, twoStepsBack + nums[i]);
         twoStepsBack = temp;
     }
     return oneStepBack;
 }*/

