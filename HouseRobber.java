/**
 * Time Complexity: O(n) where n is the number of houses
 * Space complexity: O(1)
 * Ran on leetcode? Yes
 * Any problems faced?: No
 *
 * Approach:
 * - Greedy fails here if the array is like 2,8,9,8,1,5
 * - There are repeating sub-problems, so can use DP to compute min at each row based on the rules
 *  example -
 *     skip | rob
 *  2   0   | 2
 *  7.  2.  | 7
 *  9.  7.  | 11
 *  8  11.  | 15
 *  1  15.  | 12
 *  5. 15.  | 20
 *
 *  1. if we skip current house, the max is the max robbed till the last house
 *  2. if we rob current house, the previous house would have been skipped,
 *  so rob the current house and update rob with new value
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int skip = 0;
        int rob = 0;

        for (int n: nums) {
            int currSkip = skip;
            skip = Math.max(skip, rob);
            rob = currSkip + n;
        }

        return Math.max(skip, rob);
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] values = {2,7,9,8,1,5};
        int result = obj.rob(values);
        System.out.println("Result: " + result);
        assert (result == 12);
    }
}
