198.HOUSE ROBBER
        *You are a professional robber planning to rob houses along a street.Each house has a certain amount of money stashed,the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house,return the maximum amount of money you can rob tonight without alerting the police.

        Example 1:
        Input:nums=[1,2,3,1]
        Output:4
        Explanation:Rob house 1(money=1)and then rob house 3(money=3).
        Total amount you can rob=1+3=4.

        Example 2:
        Input:nums=[2,7,9,3,1]
        Output:12
        Explanation:Rob house 1(money=2),rob house 3(money=9)and rob house 5(money=1).
        Total amount you can rob=2+9+1=12.

        Constraints:
        1<=nums.length<=100
        0<=nums[i]<=400

--------------------------------------- Approach 1 ----------------------------------------------
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
        /* Used DP and 2 variables where we have options either to choose or skip and keep updating the maximum result accordingly.
         */

class Solution {

    public int rob(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;

        int choose =nums[0], skip = 0;
        for(int i=1; i<nums.length; i++){
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip + nums[i];
        }
        return Math.max(skip, choose);
    }
}

--------------------------------------- Approach 2 ----------------------------------------------
// Time Complexity : O(N)
// Space Complexity : O(N) --> recursive stack
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Used recursion to check the max of both choose and don't choose scenarios at every index
* */

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        return robFrom(nums, 0, 0);
    }

    private int robFrom(int[] nums, int index, int maxEarnings){
        if(index>=nums.length)
            return maxEarnings;
        //choose
        int choose = robFrom(nums, index+2, maxEarnings + nums[index]);
        //dont choose
        int dontChoose = robFrom(nums, index+1, maxEarnings);

        return Math.max(choose, dontChoose);
    }
}

----------------------------- Approach 3 ------------------------------------------------
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Used memoization to store intermediate values so that no need to calculate the same for every subarray
Used recursion to check the alternate houses max amount
* */

class Solution {
    int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new int[100];
        Arrays.fill(memo, -1);
        return robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {

        if (i >= nums.length)
            return 0;
        //if already calculated
        if (memo[i] > -1)
            return memo[i];
        //Recursion
        int ans = Math.max(robFrom(i + 1, nums), robFrom(i + 2, nums) + nums[i]);

        memo[i] = ans;
        return ans;
    }
}