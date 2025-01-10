// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No
class Problem2 {
    // Time Complexity : O(n) -> for dp solution
    // Space Complexity : O(n) -> for dp solution
    //here the approach is to user 2 d array row -> house money, col -> 0  and 1, 1 = if we rob the current house, 0= if we don't rob the current house.
    public int robuUsingDpArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            //if we don't rob the current house than money robbed can be max between the prev house robbed or prev house not robbed.
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //if we rob the current house then we've to add the value of current house to the prev house not robbed.
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }


    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int robUsingVariables(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        int skip = 0;
        int rob = nums[0];
        for(int i = 1 ;i<nums.length;i++){
            int tempSkip = skip;

            //if we don't rob the current house than money robbed can be max between the prev house robbed or prev house not robbed.
            skip = Math.max(skip,rob);
            //if we rob the current house then we've to add the value of current house to the prev house not robbed.
            rob = tempSkip + nums[i];
        }
        return Math.max(skip,rob);
    }

}