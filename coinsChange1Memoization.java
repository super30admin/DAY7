// Time Complexity :O(coins.length * amount). 
// Space Complexity :O(coins.length * amount). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, I found memoization logic is easy to build up after a brute force recursive solution

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize memoization array with -1
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        // Call helper function to find minimum coins needed
        int result = helper(coins, amount, 0, memo);
        
        // If result is larger than a reasonable max (indicating no solution found), return -1
        if (result >= 99999) {
            return -1;
        }
        
        // Otherwise, return the minimum coins needed
        return result;
    }
    
    // Helper function to recursively find minimum coins needed
    private int helper(int[] coins, int amount, int idx, int[][] memo) {
        // Base cases:
        // If amount is 0, no more coins needed
        if (amount == 0) {
            return 0;
        }
        
        // If all coins have been considered or amount is negative, return a large number
        if (idx == coins.length || amount < 0) {
            return 99999;
        }

        // If result for current state (idx, amount) is already computed, return memoized value
        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        // Recursive cases:
        // Option 1: Not pick the current coin (move to the next coin)
        int notPick = 0 + helper(coins, amount, idx + 1, memo);

        // Option 2: Pick the current coin (subtract its value from amount)
        int pick = 99999;
        if (amount >= coins[idx]) {
            pick = 1 + helper(coins, amount - coins[idx], idx, memo);
        }

        // Memoize the minimum of the two options
        memo[idx][amount] = Math.min(notPick, pick);
        
        // Return the minimum coins needed for the current state (idx, amount)
        return Math.min(notPick, pick);
    }
}
