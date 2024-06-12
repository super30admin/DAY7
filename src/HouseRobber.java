// Time Complexity : brute force O(2^n) , dp- o(n)
// Space Complexity : brute force O(n), dp o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

/**https://leetcode.com/problems/house-robber/
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 *
 */

class HouseRobber {
    public int rob(int[] nums) {
        
       //edge case
      if(nums==null || nums.length ==0) return 0;
      return dp(nums);
    }
    
    private int dp(int[] nums) {
        int prevCase1 = 0;
        int prevCase2 = nums[0];
        
        for(int i=1; i< nums.length; i++) {
            //if we do not rob current house, max earnings from prev house cases
            int case1 = Math.max(prevCase1, prevCase2);
            
            //if we rob current house then earnings from prev house not robbed case + current house earnings
            int case2 = prevCase1 + nums[i];
            
            prevCase1 = case1;
            prevCase2 = case2;
        }
        
        return Math.max(prevCase1, prevCase2);
    }
    private int bruteForce(int[] nums, int index, int robbedMoney){
        //base
        //index can be = due to +1 or can be > due to +2
        if(index >= nums.length) return robbedMoney;
        
        //logic
        //dont rob current house, move to next house, no change in robbedMoney
        int case1 = bruteForce(nums, index+1, robbedMoney);
        
        //rob current house, can not rob next house, move by 2, increase robbed money
        int case2 = bruteForce(nums, index+2, robbedMoney + nums[index]);
        
        return Math.max(case1, case2);
                
    }
}