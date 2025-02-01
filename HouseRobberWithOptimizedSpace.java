// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through the houses and maintain two variables (prev and curr) to store the maximum
// amount of money robbed up to the previous and current house, and update them iteratively.

public class HouseRobberWithOptimizedSpace {
    public int rob(int[] nums) {
        int len = nums.length;
        int prev = nums[0];

        if (len == 1) return prev;
        int curr = Math.max(prev, nums[1]);

        for (int i = 2; i < len; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
