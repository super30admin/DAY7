
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class HouseRobberRecursive {
    public int rob(int[] nums) {
        return helper(0,0,nums);

    }
    public int  helper(int index, int amount, int[] nums){
        //Base
        if(index>=nums.length){
            return amount;
        }

        // case1 Not choosing
        int case1 = helper(index+1,amount,nums);

        //case2 choose
        int case2 = helper(index+2,amount+nums[index],nums);

        return Math.max(case1,case2);
    }
}
