// Time complexity = O(n)
// Space complexity = O(1)
// dp using 2 pointers.
class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length<=1) {
            return nums[0];
        }        
        int prev = nums[0];
        int curr= Math.max(nums[0],nums[1]+0);
        for(int i=2;i< nums.length;i++) {
            int temp = curr;// just get the current current value.
            curr = Math.max(prev + nums[i], curr);// current value updated.
            prev = temp;// temp value updated.
            }
            return curr;
        }
}

/**
// dp array.
// 1d array - only 1 decision variable matters -> nums.
class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], 0+nums[1]);
        for(int i=2;i< nums.length;i++) {            
             dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            // the max between the 2 steps before + current, and the 1 step before.
        }
        return dp[nums.length-1];
    }
}
**/
// // recursion.
// class Solution {
//     public int rob(int[] nums) {
//         return recursion(nums, 0 );
//     }
    
//     private int recursion(int[] nums, int idx) {
//         // base case.
//         if(idx >= nums.length) {
//             return 0;
//         }
//         // logic
//         int case1= recursion(nums, idx+1);// skip the house idx.
//         int case2= nums[idx] + recursion(nums,idx+2); // take the house idx and go to the next to adjacent house.
//         return Math.max(case1, case2);// take the max.
//     }
// }