/*
    Time Complexity : O(2^n) n=> no of houses

    Space Complexity : O(n) due to the recursive call stack depth.

    Did this code successfully run on Leetcode : No, Time limit exceeded
 */
class HouseRobberExhaustiveApproach {
    public int rob(int[] nums) {

        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i, int totalRobbings)
    {
        //base case
        if(i >=  nums.length) return totalRobbings; //>= and not == because we are doing i+2 so index might reach out of bounds

        //logic
        int case0 = helper(nums, i+1, totalRobbings); //not robbing

        int case1 = helper(nums, i+2, totalRobbings+nums[i]);//robbing

        return Math.max(case0, case1);
    }
}