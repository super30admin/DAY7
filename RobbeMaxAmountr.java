class Solution {
    public int rob(int[] nums) {
      if(nums== null || nums.length == 0) return 0;
        
        int nc = 0;
        int c = 0;
        
        
        for( int i =0;i< nums.length;i++){
          int  temp = c;
            c = nums[i]+ nc;
            nc = Math.max(nc,temp);
        }
        return Math.max(c,nc);
        
    }
}

/*
TimeComplexity :O(n)
SpaceComplexity:O(n)
*/