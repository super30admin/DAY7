//198. House Robber - https://leetcode.com/problems/house-robber/description/
//Time Complexity: 2 ^(n) where 'n' is number of houses
//Space Complexity:

//Recurrsive Approach:
class Solution {
    public int rob(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int amount){
        //base case
        if(index >= nums.length){
            return amount;
        }
        //logic
        int choose = helper(nums, index+2, amount + nums[index]);
        int notChoose = helper(nums, index+1, amount);
        return Math.max(choose, notChoose);
    }
}

//DP Approach
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //base case
        if(nums == null || n == 0){
            return 0;
        }
        //for case when only 1 element exists in nums array
        if (n == 1) {
            return nums[0];
        }
        //initialize choose, not_choose columns for each nums element
        int[] dp = new int[n];
        //choose
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //i=1 cz we already chose 1 element, now the loop will start from 2nd element
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1] ;
    }
}

//2-Pointer Solution
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //base case
        if(n == 1){
            return nums[0];
        }

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++){
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }

        return curr ;
    }
}
