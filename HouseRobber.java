class HouseRobber {
// Time Complexity : O(N), N is the length of the array
// Space Complexity : O(N), N is the length of the array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
    /* Using dp array
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0]; // if we have only one house, we rob that itself
        int[] dp = new int[n];

        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);// we choose max value between previous house value and current house value + previous to previous house value
        }

        return dp[n-1];
    }
    */ //Using variables
        // Time Complexity : O(N), N is the length of the array
        // Space Complexity : O(1)
        public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0]; // if we have only one house, we rob that itself
       

        int prev = nums[0]; 
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i]+prev);// we choose max value between previous house value and current house value + previous to previous house value
            prev = temp;
        }

        return curr;
    }

}

/*  
    //using Recursion
    // Time Complexity : O(2^N), N is the length of the array
    // Space Complexity : O(2^N), stack space
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int i, int amount) {
        //base case
        if(i >= nums.length) return amount; // we are not moving linearly, we are incrementing i by 1 in case0 and i by 2 in case1

        //logic
        int case0 = helper(nums, i+1, amount);
        int case1 = helper(nums, i+2, amount+nums[i]);

        return Math.max(case0, case1);
    }
*/