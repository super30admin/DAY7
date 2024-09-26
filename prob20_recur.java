// S30 Big N Problem #20 {Easy}
// 198. House Robber
// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
// Time Limit Exceeded

// Your code here along with comments explaining your approach
//Recursive approach
class Solution {
    public int rob(int[] nums) {
        return foo(nums,0,0);
    }
    private int foo(int [] nums, int index, int sum){
        //base case
        if(index>=nums.length) return sum;
        //logic
        //choosen
        int case1 = foo(nums,index+2, sum+nums[index]);
        
        //not choosen
        int case2 = foo(nums,index+1,sum);
        
        return Math.max(case1,case2);
    }
}