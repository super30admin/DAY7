// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int [coins.length+1][amount+1];
        
        for(int j =1;j<dp[0].length;j++){
            dp[0][j] = 10001;
        }

        for(int i = 1; i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1]>=10001) return -1;
        return dp[dp.length-1][dp[0].length-1];
    }
    public int helper(int i, int amount, int count,int[] nums){
        if(amount == 0) return count;
        if(amount<0 || i>=nums.length) return -1;
        int nc = helper(i+1, amount, count, nums);
        int c = helper(i, amount-nums[i], count+1, nums);
        if(nc == -1) return c;
        if(c == -1) return nc;
        return Math.min(c,nc);
    }
}