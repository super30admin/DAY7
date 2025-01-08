// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Create memoization for do not rob and rob and store decision of previous in skip or taken
 */

class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n =nums.length;
        int skip = 0;
        int take = nums[0];
        for(int i=1;i<n;i++){
            int tempSkip = Math.max(skip, take);
            take = skip + nums[i];
            skip= tempSkip;
        }
        return Math.max(skip, take);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(nums));
    }
}