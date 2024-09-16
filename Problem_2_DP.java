// Time complexity - O()
// Space complexity - O()

// DP solution using dp array of length nums. Check for max values of nums[i]+i-2th index or nums[i-1].

class Solution {
    public int rob(int[] nums) {
    
    // Edge case
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        
        // Logic
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
