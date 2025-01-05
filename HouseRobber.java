// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

/*
 * Since only adjacent houses cannot be robbed, our formula is
 * currentMax = max(prevMax, currentHouse + secondPreviousMax) for each house
 * Thus by maintaining 3 vars - curr, prev, prev2 - we can iterate over the
 * array and use the formula to find the max amount at the last house.
 */
class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int curr, prev, prev2;
        prev2 = 0;
        prev = 0;
        curr = 0;
        for (int num : nums) {
            curr = Math.max(prev, num + prev2);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}