// Time Complexity: 1) recursion approach:O(2^n) as recursion stack is built, 
// 2) using DP but 2d Array: O(n) as num array is traversed, 3) using dp but 3 variables: O(n) as num array is traversed

// Space Complexity: 1) recursion approach: O(2^n), 2) using DP but 2d Array: O(n) as column length is constant ,
// 3) using dp but 3 variables: O(1)

// Recursion is the exhaustive approach which is not an ideal solution for logic which requires less computation time.
// Using DP array is a good choice but space complexity is O(n)
// Using 3 variables is a best choice ås space complexity is O(1)
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(robUsingRecursion(new int[] {})); // 0
        System.out.println(robUsingRecursion(new int[] { 1, 2, 3, 1 })); // 4
        System.out.println(robUsingRecursion(new int[] { 2, 7, 9, 3, 1 })); // 12

        System.out.println(robUsingDP2Darray(new int[] {})); // 0
        System.out.println(robUsingDP2Darray(new int[] { 1, 2, 3, 1 })); // 4
        System.out.println(robUsingDP2Darray(new int[] { 2, 7, 9, 3, 1 })); // 12

        System.out.println(robUsing3Variables(new int[] {})); // 0
        System.out.println(robUsing3Variables(new int[] { 1, 2, 3, 1 })); // 4
        System.out.println(robUsing3Variables(new int[] { 2, 7, 9, 3, 1 })); // 12
    }

    public static int robUsingRecursion(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        return recurse(nums, 0, 0);
    }

    private static int recurse(int[] nums, int index, int amount) {
        // base case when to stop recursion
        if (index >= nums.length)
            return amount;

        // logic
        // if not robbed
        int case1 = recurse(nums, index + 1, amount);

        // if robbed
        int case2 = recurse(nums, index + 2, amount + nums[index]);
        return Math.max(case1, case2);
    }

    private static int robUsingDP2Darray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int dp[][] = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int row = 1; row < nums.length; row++) {
            dp[row][0] = Math.max(dp[row - 1][0], dp[row - 1][1]);
            dp[row][1] = dp[row - 1][0] + nums[row];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    private static int robUsing3Variables(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int skipped = 0;
        int robbed = nums[0];
        for (int row = 1; row < nums.length; row++) {
            int tempSkipped = skipped;
            skipped = Math.max(skipped, robbed);
            robbed = tempSkipped + nums[row];
        }
        return Math.max(skipped, robbed);

    }
}