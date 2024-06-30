// Time Complexity : O(m*n) m will be number of coins and n will be amount.
// Space Complexity : O(m*n) m will be number of coins and n will be amount.
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : I always find it hard to apply dynamic programming logic in a problem. So, I followed the solution given in class.


// Your code here along with comments explaining your approach
// The logic applied here is if the coin we are using at row level if less than current column index we will take the element from just above row as it is.
// Then, once the current coin and column index matches, then we will check if the current above matrix element is minimum or the element which is coins 
// places behind it + 1. Then we will assign that element at current matrix. The last element in the matrix will be minimum coins used.
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        
        int m = coins.length;
        int n = amount;
        // int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];

        for (int j = 1; j <= n; j++) {
            // dp[0][j] = 999999;
            dp[j] = 999999;
        }

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i-1]) {
                    // till amount < denomination of curr coin
                    // dp[i][j] = dp[i-1][j];
                    dp[j] = dp[j];
                } else {
                    // dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
                }
            }
        }

        // int re = dp[m][n];
        int re = dp[n];

        if (re >= 999999) {
            return -1;
        }

        return re;
    }
}



// Time Complexity : O(n) as we will iterate through all the elements in nums.
// Space Complexity : O(n) as we will store current maximum robbing in the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved the problem using explaination in the class.


// Your code here along with comments explaining your approach
// In this problem the main logic is we will check what is maximum robbery can a robber do with whether to choose or not choose decision.
// To calculate the maximum amount we can check what will be the maximum between the current element and i-2 element total or the previous i-1 element total.
// We will consider the path which gives us maximum amount and the last element in the array will give us an amount which is maximum. 
class Solution {
    public int rob(int[] nums) {
        
        // return helper(nums, 0);

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[n-1];

    }

    private int helper(int[] nums, int idx) {

        if (idx >= nums.length) {
            return 0;
        }

        int case1 = nums[idx] + helper(nums, idx + 2);
        int case2 = 0 + helper(nums, idx + 1);

        return Math.max(case1, case2);

    }
}