// Top-down approcah with memoization
//Time complex: O(N)
//Space Complex : O(N)
class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+2];
        Arrays.fill(dp, -1);
        int sum = rob(nums, 0);
        return sum;
        
    }
    public int rob(int[] nums, int index){
        if(index>nums.length-1)
            return 0;
            
        if(dp[index]>-1)
            return dp[index];
            
        if(dp[index]==-1){
            int rob = nums[index] + rob(nums, index+2);

            int notrob = rob(nums, index+1);

            dp[index] = Math.max(rob,notrob);
        }
        
        return dp[index];
    }
}

//Bottom-up approach
//Time and Space Complexity: O)(N)
class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+2];
        
        for(int i=nums.length-1; i>=0;i--){
            int rob = nums[i] + dp[i+2];
            int notrob = dp[i+1];
            
            dp[i] = Math.max(rob,notrob);
        }
        
        return dp[0];
        
    }
}
