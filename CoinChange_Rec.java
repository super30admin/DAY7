// Time Complexity : O(2^(mn)) --> where n is length of array and m is amount
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode (322): Yes
// Any problem you faced while coding this : No

// Explanation: In this 'Coin Change' problem we are recursively iterating over each possibility to get the minimum number of coins. In each iteration we have 2 choices i.e. (1) to choice a coin and (2) to no choose a coin. If we consider choice 1 then the target amount will get reduced by the coin we chose but the number of available coins will remain same. And if we consider choice 2 then the available coins will get reduce by 1 but the amount will remain same. Going with this recurrsion approach, there will be multiple similar sub-cases that we will have to compute each and every time and so this is not a good approach to solve this kind of problems. Hence, its time complexity will be exponential.


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        
        return helper(coins, amount, 0, 0);
    }
    
    private int helper(int[] coins, int amount, int index, int min) {
        // base case
        if (amount == 0) return min; // positive case
        if (amount < 0 || index == coins.length) return -1; // negative case
        
        // logic
        // choose a coin
        int case1 = helper(coins, amount - coins[index], index, min + 1);
        
        //doesn't choose a coin
        int case2 = helper(coins, amount, index + 1, min);
        
        if (case1 == -1) return case2;
        if (case2 == -1) return case1;
        
        return Math.min(case1, case2);
    }
}