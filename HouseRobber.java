// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int rob(int[] nums) {
    // 2 cases: skip is when that house is skipped, take is when that house is robbed
    int skip = 0;
    int take = nums[0];
    // Updating skip to the max of previous skip and take, take to the sum of previous skip and present house.
    for(int i = 1; i<nums.length; i++) {
      int tempSkip = skip;
      skip = Math.max(skip, take);
      take = tempSkip + nums[i];
    }
    return Math.max(skip, take);
  }
}