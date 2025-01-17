// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0; // No houses
       if (nums.length == 1) return nums[0];          // Only one house

       // Variables to store the maximum profit up to the previous two houses
       int prev1 = 0; // Max profit up to the previous house
       int prev2 = 0; // Max profit up to the house before the previous

       for (int num : nums) {
           int temp = prev1;
           // Max profit for the current house is the max of:
           // 1. Robbing this house + profit up to two houses before
           // 2. Not robbing this house (carry forward the previous max profit)
           prev1 = Math.max(prev1, prev2 + num);
           prev2 = temp;
       }

       return prev1; // Maximum profit
   }
    
}
