// TC - O(N)
// SC - O(N)

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

public class HouseRobberDP {
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int[] matrix = new int[nums.length + 1];
            matrix[0] = 0;
            matrix[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                matrix[i] = Math.max(matrix[i - 1], matrix[i - 2] + nums[i - 1]);
            }

            return matrix[nums.length];
        }
    }
}
