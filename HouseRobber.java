/* Description: Using 2 variables to store the value of Rob the house or do not rob the house. At any current row, the value of do not rob the house
 * is given by max of previous row values, and the value of rob the house is given by adding the value of robbing the current house to the 
 * do not rob value of previous house. Getting the final ans from the max of last row.
 */
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
// Recursion approach
class Solution {
    public int rob(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Recurse function
        return recurse(nums, 0, 0);
    }

    private int recurse(int[] nums, int index, int amountRobbed) {
        // Base
        if (index >= nums.length) {
            return amountRobbed;
        }
        // Logic
        // 0 or do not pick the house
        int case1 = recurse(nums, index + 1, amountRobbed);
        // 1 or pick the house
        int case2 = recurse(nums, index + 2, amountRobbed + nums[index]);
        return Math.max(case1, case2);
    }
}

// 2d array - but space here is O(n)
class Solution1 {
    public int rob(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // 2d array with the row having the houses and columns as Rob (1) and do not
        // rob(0)
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // Do not rob
        dp[0][1] = nums[0]; // Rob
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}

// constant space
class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // 2 Variables storing the rob and do not rob
        int skip = 0; // Do not rob
        int take = nums[0]; // rob
        for (int i = 1; i < n; i++) {
            // Storing the current value of skip
            int skipOld = skip;
            // Changing the skip to the max of previous row
            skip = Math.max(skip, take);
            // Changing take to old skip plus current house robbed value
            take = skipOld + nums[i];
        }
        // Returning max of last row
        return Math.max(skip, take);
    }

}