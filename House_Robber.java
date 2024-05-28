// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// find max of n-2 + n , n-1 for entire array, update n locations
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int house_1 = nums[0];
        int house_2 = nums[1];//Math.max(house_1, nums[1]);

        // [house_1, house_2, n, n-1, ...]
        for (int i = 2; i<nums.length; i++){
            int temp = Math.max(house_1 + nums[i], house_2);

            house_1 = house_2;
            house_2 = temp;
        }
        return house_2;
    }
}