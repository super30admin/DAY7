
// Time Complexity :O(n)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

class HouseRobber {
 
    public int rob(int[] nums) {
        
 if (nums.length == 0 || nums == null) 
        return 0; 
   
        int i = nums[0]; 
        if (nums.length == 1) 
            return i; 
   
        int j = Math.max(nums[0], nums[1]); 
        if (nums.length == 2) 
            return j; 
        
        int newMax = 0; 
    
        for (int k=2; k<nums.length; k++) 
        { 
            newMax = Math.max(nums[k]+i, j); 
            i = j; 
            j = newMax; 
        } 
   
        return newMax;
} 
}