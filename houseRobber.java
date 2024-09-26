// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}






// // TC O(n) SC O(n)
// // using variables to optimize it would be O(1)

// class Solution {
//     public int rob(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         if(nums.length < 2) return nums[0];
//         return helper(nums, 0, 0);
//     }
//     private int helper(int[] nums, int idx, int amountRobbed){
//         //base
//         if(idx >= nums.length) return amountRobbed;

//         //rob
//         int case1 = helper(nums, idx+2, amountRobbed + nums[idx]);
//         //dont rob
//         int case0 = helper(nums, idx+1, amountRobbed);
//         return Math.max(case0,case1);
//     }
// }