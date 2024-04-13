// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, i had to wait for the lecture to help me solve this.

/*
 * Approach: Running sum
 *  Logic: at i+1 either take the current (i-1) or take the prev (i-2)+ nums[i] -> the i-2 is a sub-problem we already solved.
 * 
 * 
 */
public class HouseRobberDP {

    /*
     * Time compelixty - O(n)
     * Space complexity - O(n)
     */

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }

        return dp[nums.length - 1];
    }

    /*
     * Time compelixty - O(n)
     * Space complexity - O(1)
     * 
     */

    public int robWithOutArray(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;

        }

        return curr;
    }

}