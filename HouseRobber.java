// Time Complexity: O(n), where n is the number of elements in the nums array.
//                  The algorithm iterates through the nums array once, updating values in constant time.
// Space Complexity: O(1).
//                   The algorithm uses only a constant amount of extra space regardless of the input size.
// Approach: Dynamic Programming.
//           The approach uses a dynamic programming technique to find the maximum amount of money that can be robbed without alerting the police.
//           It maintains two variables, prev and curr, where prev represents the maximum amount of money that can be robbed up to the (i-1)th house, and curr represents the maximum amount of money that can be robbed up to the ith house.
//           It iterates through the nums array, updating prev and curr accordingly.
//           At each step, it calculates the maximum amount of money that can be robbed considering robbing the current house (nums[i]) or skipping it.
//           Finally, it returns the value of curr, which represents the maximum amount of money that can be robbed without alerting the police.

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        if(nums.length <2) return nums[0];
        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2; i<n ; i++)
        {
            int temp = curr;
            curr = Math.max(curr, prev+ nums[i]);
            prev = temp;
        }
        return curr;
       
    }

}