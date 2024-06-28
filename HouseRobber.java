// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was able to get to recursion solution easily. But transforming that logic
// to D.P was not so easy. I started by taking 2d array to solve but quickly realised it is not the correct way.

// Your code here along with comments explaining your approach
/*
Recursion concept: Either choose to rob a house, add that amount and remove both chosen and next house.If un-chosen,
keep the current amount and remove the un-chosen house. Continue until houses are finished and find the maximum tree.
The recursion approach works but is time limit exceeded.

D.P: Thinking bottom up approach. So at the last house, there are two scenarios. Either can rob this or unable to rob.
Case-1: Can rob this means, n-1 is not robbed so find the total amount as nums[n-2] + nums[n].
Case-2: Cannot rob his means, n-1 is robbed so total amount up to then is nums[n-1].
Finally, calculate the max of these above two cases which gives the answer.
 */

public class HouseRobber {
    //Start of recursion implementation
    public static int robRecursion(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return helperRecursion(nums, 0, 0);
    }

    private static int helperRecursion(int[] nums, int amount, int index) {
        // Base condition: If index goes out of bounds, return the accumulated amount
        if (index >= nums.length) {
            return amount;
        }
        // Base condition: If index is at the last element, add it to the amount
        if (index == nums.length - 1) {
            return amount + nums[index];
        }

        //case1 - choose and remove both chosen and chosen+1
        int case1 = helperRecursion(nums, amount + nums[index], index+2);

        //case2 - don't choose and remove the un-chosen one
        int case2 = helperRecursion(nums, amount, index+1);

        return Math.max(case1, case2);
    }
    //end of recursion implementation.

    //start of D.P implementation
    public static int robDP(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[len];
        dp[0] = nums[0]; //robbing first house
        dp[1] = Math.max(nums[0], nums[1]); //choose to either rob first or second house to begin with
        for(int i=2; i<len; i++) { //begin with calculating from third house to end of houses. O(n) T.C
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]); //calculate if either robbing or skipping it is better. O(n) S.C
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 7, 11};
        int[] nums2 = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,
                187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println("Total amount that can be robber from nums " +
                "using recursion is " + robRecursion(nums));
        System.out.println("Total amount that can be robber from nums2 " +
                "using recursion is " + robRecursion(nums2));
        System.out.println("Total amount that can be robber from nums " +
                "using dp is " + robDP(nums));
        System.out.println("Total amount that can be robber from nums2 " +
                "using dp is " + robDP(nums2));
    }
}