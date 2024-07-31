// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class HouseRobber {
    public static int robRecursion(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return helperRecursion(nums, 0, 0);
    }

    private static int helperRecursion(int[] nums, int amount, int index) {
        if (index >= nums.length) {
            return amount;
        }
        if (index == nums.length - 1) {
            return amount + nums[index];
        }

        int case1 = helperRecursion(nums, amount + nums[index], index + 2);
        int case2 = helperRecursion(nums, amount, index + 1);

        return Math.max(case1, case2);
    }

    public static int robDP(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 7, 11};
        int[] nums2 = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        System.out.println("Total amount that can be robbed from nums " +
                "using recursion is " + robRecursion(nums));
        System.out.println("Total amount that can be robbed from nums2 " +
                "using recursion is " + robRecursion(nums2));
        System.out.println("Total amount that can be robbed from nums " +
                "using dp is " + robDP(nums));
        System.out.println("Total amount that can be robbed from nums2 " +
                "using dp is " + robDP(nums2));
    }
}

