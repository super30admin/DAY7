// TC - O(N)
// SC - O(1)

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

public class HouseRobberDPVariables {
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int prevToAdjacentHouse = nums[0];
            int adjacentHouse = Math.max(nums[0], nums[1]);
            // [2 1 0 3 5 4]
            // [2 2 2 5 7 9]
            // 9 = max(7, 4+5)
            for (int i = 2; i < nums.length; i++) {
                int temp = adjacentHouse;
                adjacentHouse = Math.max(adjacentHouse, prevToAdjacentHouse + nums[i]);
                prevToAdjacentHouse = temp;
            }

            return adjacentHouse;
        }
    }
}
