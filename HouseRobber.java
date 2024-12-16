/*
    Leetcode problem : 
    T.C: O(n) :: S.C: O(n)

    Solved using dynamic programming approach, i.e by storing the repeated
    sub-problems of a recursive (or exhaustive) solution in a memory space
    Skip or take the current index at hand, by taking current element add 
    the current val along with the prrviously skiped element,simultaneously 
    keep track of the skipped element in a variable to calculate the max of 
    the two choices. By repeatedly performing this operation you will finally
    arrive at the end having the max of the skipped and take cases. Return!
*/

class Solution {
    public int rob(int[] nums) {
        int maxAmount = 0;
        int n = nums.length;

        if (nums == null || n == 0) return maxAmount;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int skip = 0;

        for (int i = 1; i < n; i++) {                    
            dp[i] = skip + nums[i];
            skip = Math.max(skip, dp[i - 1]);
        }
        
        return Math.max(skip, dp[n - 1]);
    }
}