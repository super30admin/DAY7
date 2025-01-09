class HouseRobberSolution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int rowsAmounts = nums.length;
        int[][] dp = new int[rowsAmounts][2];// 2 - 0 for not rob , 1 for rob
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < rowsAmounts; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[rowsAmounts - 1][0], dp[rowsAmounts - 1][1]);
    }
}