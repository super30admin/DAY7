// TC: O(n)
// SC: O(n)

class LC198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums[i];
            if (i >= 2)
                p += dp[i - 2];
            int np = 0;
            if (i >= 1)
                np += dp[i - 1];
            dp[i] = Math.max(p, np);
        }
        return dp[n - 1];
    }
}