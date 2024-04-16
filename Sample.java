//Problem 1: https://leetcode.com/problems/coin-change/
// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity :O(m*n) where m is the number of coins and n is the amount          
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : This code attempts to find the minimum number of coins needed to make up the given amount, using the coins provided. It initializes an array dp with size amount + 1 and fills it with amount + 1 as a placeholder value. It then iterates through each coin denomination and each amount from 1 to amount, updating dp with the minimum number of coins needed to make up that amount. If dp[n] is still amount + 1 after the loops, it means the amount cannot be made up using the given coins, so it returns -1. Otherwise, it returns the value in dp[n].

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = amount + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        if (dp[n] >= amount + 1) {
            return -1;
        } else {
            return dp[n];
        }
    }
}

// Problem 2: https://leetcode.com/problems/house-robber/
// Time Complexity : O(n) where n is the number of houses
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : This code attempts to find the maximum amount of money that can be robbed from the given array of houses. It initializes two variables prev and curr to keep track of the maximum amount of money that can be robbed at the previous house and the current house, respectively. It then iterates through the array, updating prev and curr with the maximum amount of money that can be robbed at each house. Finally, it returns the value of curr.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }    
}