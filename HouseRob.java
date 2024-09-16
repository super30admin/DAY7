//Time Complexity: O(n)
//Space Complexity : O(1)
//LeetCode : Yes

//Since its the maximum amount that is to be found, just initialise two variable based on the decision to select the house or not. 
//A temporary variable to store the previous value. Maximum of the  final sel and dsel values will the maximum amount that can be robbed. 


class Solution {
    public int rob(int[] nums) {
        //base
        if(nums == null || nums.length ==0)return -1;
        
        int sel = nums[0];
        int dsel = 0;
        for(int i=1;i<nums.length;i++){
            int temp = dsel;
            dsel = Math.max(sel, dsel);
            sel = temp + nums[i];
        }
        return Math.max(sel,dsel);
    }
}