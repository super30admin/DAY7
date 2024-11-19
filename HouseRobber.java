// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {

		if (nums.length == 0 || nums == null)
			return 0;
		else {
			int evenCount = 0, oddCount = 0;
			for (int i = 0; i < nums.length; i++) {

				if (i % 2 == 0) {
					evenCount += nums[i];
					evenCount = evenCount > oddCount ? evenCount : oddCount;
				} else {
					oddCount += nums[i];
					oddCount = evenCount > oddCount ? evenCount : oddCount;
				}
					
			}
			return evenCount >= oddCount ? evenCount : oddCount;
		}

	}
}
