class Solution {
    public int rob(int[] nums) {
        if(nums.length>=2){
        
        nums[1]=Math.max(nums[0],nums[1]);
        if(nums.length>=3){
       for(int i=2;i<nums.length;i++){
        nums[i]= Math.max(nums[i-1],nums[i]+nums[i-2]);
       }
        }
        }
         return nums[nums.length-1];
    }
}