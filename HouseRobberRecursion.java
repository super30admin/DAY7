// TC - O(2^N)
// SC - O(2^N)

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

public class HouseRobberRecursion {
    class Solution {
        public int rob(int[] nums) {
            return helper(nums, 0, 0);
        }

        private int helper(int[] nums, int index, int robbedMoney) {
            if (index >= nums.length) {
                return robbedMoney;
            }

            int currHouseRobbedMoney = helper(nums, index + 2, robbedMoney + nums[index]);
            int currHouseNotRobbedMoney = helper(nums, index + 1, robbedMoney);

            return Math.max(currHouseRobbedMoney, currHouseNotRobbedMoney);
        }
    }
}
