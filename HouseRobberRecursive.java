// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Had to wait for the professor to explain

/*
 * Recursive approach:
 * we start with 0
 * 
 * logic: 
 * case0 -> if we choose to rob i -> total = total+nums[i] & sub-array index would start from i+2
 * case1 -> if we chose to not rob i -> total will stay the same & sub-array is i+1 (rob the next house)
 */
public class HouseRobberRecursive {

    public int rob(int[] nums) {
        return helper(nums, 0, 0);

    }

    private int helper(int[] nums, int i, int total) {
        // base case
        if (i >= nums.length)
            return total;

        // logic
        int case0 = helper(nums, i + 2, total + nums[i]);
        int case1 = helper(nums, i + 1, total);

        return Math.max(case0, case1);
    }
}