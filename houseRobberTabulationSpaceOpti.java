// Time Complexity :O(N)
// Space Complexity :O(1). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        // Handle edge case where there is only one house
        if (nums.length == 1) return nums[0];
        
        // Initialize variables to store the maximum amount that can be robbed up to the previous and current house
        int prev = nums[0]; // If there's only one house to rob
        int current = Math.max(nums[0], nums[1]); // Max value between robbing the first or the second house
        
        // Iterate over the remaining houses, starting from the third house
        for (int i = 2; i < nums.length; i++) {
            // Temporary variable to hold the current maximum amount
            int temp = current;
            
            // Update current to be the maximum of either not robbing the current house (current)
            // or robbing the current house and adding its value to the maximum from two houses before (nums[i] + prev)
            current = Math.max(current, nums[i] + prev);
            
            // Update prev to be the old current value for the next iteration
            prev = temp;
        }
        
        // The current variable contains the maximum amount that can be robbed up to the last house
        return current;
    }
}
