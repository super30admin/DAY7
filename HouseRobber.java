class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // return recurse(nums, 0, 0);

        // DP solution
        // int[][] dp = new int[nums.length][2];
        // dp[0][0] = 0;
        // dp[0][1] = nums[0];

        // for(int i = 1; i < nums.length; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        //     dp[i][1] = dp[i - 1][0] + nums[i];
        // }
        // return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

        // DP solution 2
        int skip = 0;
        int take = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }

    private int recurse(int[] nums, int index, int moneyRob) {
        // base
        if(index >= nums.length) {
            return moneyRob;
        }

        // logic
        int case1 = recurse(nums, index + 1, moneyRob);
        int case2 = recurse(nums, index + 2, moneyRob + nums[index]);

        return Math.max(case1, case2);
    }
}
