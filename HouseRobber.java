/**
 * Time Complexity: O(n) where n is the number of houses
 * Space complexity: O(1)
 * Ran on leetcode? Yes
 * Any problems faced?: No
 *
 * Approach:
 * - Greedy fails here if the array is like 2,8,9,8,1,5
 * - There are repeating sub-problems, so can use DP to compute min at each row based on the rules
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int prev = 0;
        int max = 0;

        for (int num : nums) {
            int temp = Math.max(max, prev + num);
            prev = max;
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] values = {2,7,9,8,1,5};
        int result = obj.rob(values);
        System.out.println("Result: " + result);
        assert (result == 12);
    }
}
