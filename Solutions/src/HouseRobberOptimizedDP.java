// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class HouseRobberOptimizedDP {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int chosen=nums[0];
        int notchosen=0;
        for (int i=1;i<nums.length;i++){
            int temp = chosen;
            chosen = notchosen+nums[i];
            notchosen = Math.max(temp,notchosen);

        }
        return Math.max(notchosen,chosen);
    }
}