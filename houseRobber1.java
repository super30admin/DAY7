/*
Observations -->

1. No two alternative homes can be captured
2. The amount and the index are changing
3. We have to maximize the sum for we can think of using Greedy 1st, Recurssion 2nd and Dp 3rd
TC --> O(n)
SC --> O(n)
 */
import java.util.*;

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            //not taken
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //taken
            dp[i][1] = nums[i] + dp[i - 1][0];

        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);

    }
}
