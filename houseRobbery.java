// Problem2 (https://leetcode.com/problems/house-robber/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * In this problem, dynamic programming is implemented where using the 2 variables named prev and curr. curr variable will be moved across the
 * array from left ro right. prev would be 0th index element at start and curr would be max of prev index element and element at curr index,
 * for all the elements later curr is max of prev, prev + element at that index will be taken and prev is moved to previous curr. The curr
 * variable is returned.
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(prev, nums[1]); 

        for (int i = 2;i<nums.length;i++) {
            int temp = curr;
            curr = Math.max(temp, prev + nums[i]);
            prev = temp;

        }
        return curr;
    }
}