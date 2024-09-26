// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        //Taking two variables to store current and previous money
        int prev = nums[0];
        if(nums.length == 1) return prev;
        int curr = Math.max(prev, nums[1]);

        //Itearting over all the elements
        for(int i=2; i<nums.length; i++){
            //Storing value of current as it will be changed later
            int temp = curr;
            //Getting max of if we take the current element or if we do not take the current elentn
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }

// Return max value which will be stored in curr
        return curr;
    }
}