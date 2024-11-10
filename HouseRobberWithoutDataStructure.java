/*
    Time Complexity : O(n) n is the number of houses

    Space Complexity : O(1)

    Did this code successfully run on Leetcode : Yes
 */

class HouseRobberWithoutDataStructure {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n==1) return nums[0]; //if we have only 1 house

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i<n; i++)
        {
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }

        return curr;
    }
}
