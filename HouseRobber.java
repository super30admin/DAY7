// TC: O(n) n: number of houses
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HouseRobber {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        if(nums.length == 1) return nums[0];
        else{
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}

//TC: O(n) n: number of houses
//SC: O(1) Saving the space by maintaining 2 variables rather than maintaining a dp array
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Solution {
    public int rob(int[] nums) {
        int prev,curr;
        if(nums.length == 1) return nums[0];
        else{
            prev = nums[0];
            curr = Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<nums.length;i++) {
            int temp = curr;
            curr = Math.max(temp,nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
}