// Time Complexity : O(n) where n is array size
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HouseRobber {
	public int rob(int[] nums) {        
         if(nums.length==0 || nums==null) 
             return 0;
        
         if(nums.length<2) return nums[0];
        
         if(nums.length==2)                     
             return Math.max(nums[nums.length-1],nums[nums.length-2]);
        
            nums[1]=Math.max(nums[0],nums[1]);
        
         for(int i=2;i<nums.length;i++)
         {
             nums[i] = Math.max(nums[i-1],nums[i]+nums[i-2]); //current_val = Max(current_val+previous_eligible_sum or 	sum at (i-1))
         }
        
         return nums[nums.length-1];
        
     }
}