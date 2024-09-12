// Time Complexity : O(n) - n is the length of the input array
// Space Complexity : O(n) - n is the length of the input array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class HouseRobber1 {
    /**
     * Intuition: max of (curr house money + money robbed till curr house -2) or money robbed till curr house -1 and lastly at dp[last] will have the max money that could be robbed with the given input
     * @param nums
     * @return max money that can be robbed with gvn input
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;                                      //prev
        dp[1] = nums[0];                                // curr

        for(int i=1;i<nums.length;i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);  //max of (curr house money + money robbed till curr house -2) or money robbed till curr house -1
        }
        return dp[nums.length];                        // will have the max money that could be robbed with the given input
    }
}

//We could use an array to store and calculate the result,
//but since at each step you only need the previous two maximum values, two variables are suffice.

// Time Complexity : O(n) - n is the length of the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    /**
     * Same as the previous logic but skipped using extra mem over dp array
     * @param nums
     * @return max money that can be robbed with gvn input
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //int[] dp = new int[nums.length+1];
        int prev=0,curr=0;
        prev = 0;
        curr = nums[0];

        for(int i=1;i<nums.length;i++){
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }
        return curr;
    }
}