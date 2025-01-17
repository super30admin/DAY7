// Approach : Recursive - Exponential solution by choosing and not choosing
// Time : 2^n
// Space : O(h)
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
    }

    public int helper(int[] nums,int i , int robbings){
        // calculate max robbings

        // Base case
        if(i>=nums.length) {
            return robbings;
        }
        // Logic
        
        // Recursion
        int case0=helper(nums,i+1,robbings); // dont rob
        int case1=helper(nums,i+2,robbings+nums[i]); // rob

        return Math.max(case0,case1); // max robbings
    }
}


// Approach : DP - by resolving the repeated sub problems...
// Time : O(n)
// Space : O(n)
class Solution {
    public int rob(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(nums.length ==1){
            return dp[0];
        }
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2 ; i <n ; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
        
    }
}