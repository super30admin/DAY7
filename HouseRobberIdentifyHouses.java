// TC - O(N)
// SC - O(N)

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

public class HouseRobberIdentifyHouses {
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        boolean[] houseChosenMatrix = new boolean[nums.length];
        int prevToAdjacentHouse = nums[0];
        int adjacentHouse = Math.max(nums[0], nums[1]);
        if (adjacentHouse == nums[0]) {
            houseChosenMatrix[1] = false;
            houseChosenMatrix[0] = true;
        }
        // [2 1 0 3 5 4]
        // [2 2 2 5 7 9]
        // 9 = max(7, 4+5)
        for (int i = 2; i < nums.length; i++) {
            int temp = adjacentHouse;
            adjacentHouse = Math.max(adjacentHouse, prevToAdjacentHouse + nums[i]);
            if (adjacentHouse == temp) {
                houseChosenMatrix[i] = false;
            } else {
                houseChosenMatrix[i] = true;
            }
            prevToAdjacentHouse = temp;
        }

        int i = houseChosenMatrix.length - 1;
        while (i >= 2) {
            if (houseChosenMatrix[i]) {
                System.out.println(nums[i]);
                i -= 2;
            } else {
                i--;
            }
        }
        if (i == 2 && houseChosenMatrix[2]) {
            System.out.println(nums[0]);
        } else {
            System.out.println(Math.max(nums[0], nums[1]));
        }

        return adjacentHouse;
    }

    public static void main(String[] args) {
        System.out.println(HouseRobberIdentifyHouses.rob(new int[] { 2, 3, 0, 3, 5, 4 }));
    }
}
