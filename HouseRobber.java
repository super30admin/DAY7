class Solution {
    // TC -> O(N) , where N is the length of nums
    // SC -> O(N * 2) => O(N)
    // Repeated SUbproblems, so using DP 
    /**
            0            1
        2   0            2
        7   max(0,2)     7
        9   max(2,7)     9+2
        3   max(7,11)    3+7
        1   max(11,10)   1+11
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int maxA = 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i< nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
            maxA = Math.max(maxA, Math.max(dp[i][0], dp[i][1]));
        }
        return maxA;
    }
}
