// Time Complexity : O(2n) = O(n) => As we only have 2 columns we don't account for the number of columns
// Space Complexity : O(2n) = O(n) => As we have 2 columns and n rows
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Row represents the houses and columns will represent 2 cases(case 1 - Not robbing that house & case 2 - robbing that house).
If we decide to not rob that house, that cell value will be max of values from the prev rows but if rob that house simply add that amount with case 1 of the prev row.
 */
// class Solution {
//     public int rob(int[] nums) {

//         int[][]dp = new int[nums.length][2];
//         dp[0][0] = 0;
//         dp[0][1] = nums[0];

//         for(int i=1; i<nums.length; i++){
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); //This represents not robbing the current house

//             dp[i][1] = dp[i-1][0] + nums[i]; //Since 2 adjacent houses cannot be robbed
//         }

//         return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
//     }

// }

// Time Complexity : O(2n) = O(n) => As we are travesing through the entire array
// Space Complexity : O(1) = O(1) => As we are not utilizing any additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Instead of using 2D matrix simply use 2 variables.
 */
class Solution {
    public int rob(int[] nums) {

        int dontRobHouse = 0;    //If we don't rob the 1st house, amount will be 0
        int robHouse = nums[0]; //If we rob the 1st house, amount will be nums[i]

        for(int i =1; i<nums.length; i++){

            int tempdontRobHouse = dontRobHouse;
            dontRobHouse = Math.max(dontRobHouse, robHouse); //If we don't rob the current house, store the max values from the prev calculation

            robHouse = nums[i] + tempdontRobHouse; //If we rob the house we need to add the current value
        }

        return Math.max(dontRobHouse, robHouse);
    }
}

//This is solved using 0-1 recursion
// class Solution {
//     public int rob(int[] nums) {

//         return maxMoneyRobbed(nums, 0, 0);
//     }

//     private int maxMoneyRobbed(int[] nums, int index, int amountRobbed){

//         if(index >= nums.length){
//             return amountRobbed;
//         }

//         int case0 = maxMoneyRobbed(nums, index+1, amountRobbed);

//         int case1 = maxMoneyRobbed(nums, index +2 , amountRobbed + nums[index]); //Doing index + 2 as adjacent house cannot be robbed

//         return Math.max(case0, case1);
//     }
// }