class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int chosen=0;
        int notChosen=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp=chosen;
            chosen=notChosen+nums[i];
            notChosen=Math.max(temp,notChosen);
        }
        
        return Math.max(chosen,notChosen);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)