// ## Problem2 (https://leetcode.com/problems/house-robber/)
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.


//Recursive approach
//Time Complexity : Exponential
class Solution {
    public int rob(int[] nums) {
        //Base condition check
        if(nums==null || nums.length==0){
            return 0;
        }
        //Calling the recursive function
        return recurse(nums,0, 0);
    }

    private int recurse(int[] nums,int index, int max){
        //Base condition
        if(index>=nums.length){
            return max;
        }

        //Logic
        // 0 call
        int left = recurse(nums, index+1,max);
        //1 call
        int right =recurse(nums,index+2,max+nums[index]);

        return Math.max(left,right);

    }
}




// Dp approach
Time Complexity: O(n)
Space Complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[][] dp=new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums[i]+dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}

//Dp Solution 2
//In this we are using a constant space
Time Complexity: O(n)
Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        //Base Condition check
        if(nums==null || nums.length==0){
            return 0;
        }
        int left,right;
        left = 0;
        right = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=left;
            left=Math.max(left,right);
            right=nums[i]+temp;
        }
        return Math.max(left,right);
    }
}