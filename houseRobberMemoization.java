// Time Complexity :O(N) since we process at most N recursive calls
// Space Complexity :O(n). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[] memoDp; // Memoization array to store computed results
    
    public int rob(int[] nums) {
        this.memoDp = new int[nums.length]; // Initialize memoDp array with length of nums
        Arrays.fill(memoDp, -1); // Fill memoDp with -1 to indicate results haven't been computed yet
        
        // Call helper function with initial parameters
        return helper(nums, 0, memoDp);
    }
    
    private int helper(int[] nums, int idx, int[] memoDp) {
        // Base cases
        if (idx == nums.length - 1) return nums[idx]; // If at the last house, return its value
        if (idx >= nums.length) return 0; // If out of bounds, return 0
        
        // Memoization check: If result for idx is already computed, return it
        if (memoDp[idx] != -1) return memoDp[idx];
        
        // Recursive logic
        
        // Calculate maximum amount if current house is not picked
        int noPick = helper(nums, idx + 1, memoDp);
        
        // Calculate maximum amount if current house is picked
        int pick = nums[idx] + helper(nums, idx + 2, memoDp);
        
        // Store and return the maximum amount for current idx in memoDp
        return memoDp[idx] = Math.max(noPick, pick);
    }
}
