// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I plan to use dynamic programming and submit the assignment again after today's class


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0)
		return 0;
 
	    int even = 0;
	    int odd = 0;
 
	    for (int i = 0; i < nums.length; i++) {
		    if (i % 2 == 0) {
			    even += nums[i];
		    } else {
			    odd += nums[i];
		    }
	    }
 
	    return even > odd ? even : odd;
    }
}