// 0(n)
// constant
class Solution {
    public int rob(int[] nums) {
        int skip=0;
        int take =nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp=skip;
            skip=Math.max(take,skip);
            take=nums[i]+ temp;
        }
        return Math.max(skip,take);
    }
}