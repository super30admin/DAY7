// Time Complexity: O(n), where n is the number of houses
// Space Complexity: O(1), optimized from O(n)
class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int current = prev1;

        for (int i = 2; i < nums.length; i++) {
            current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
