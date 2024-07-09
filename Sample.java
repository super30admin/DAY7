// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//coin change
//using 2D array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp =  new int[m+1][n+1];
        for (int j=1; j<=n; j++){
            dp[0][j] = 999999;
        }
        for (int i=1; i <= m; i++){
            for(int j= 1; j <= n; j++){
                //case1 is available
                if(j < coins[i-1]){//till the time amount < denomination of current coin
                //no choose case
                dp[i][j] = dp[i-1][j];
                } else {
                    //no choose case snd choose
                    //amount-denomination of curr coin
                    dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int re = dp[m][n];

        if(re >= 999999) return -1;
        return re;
    }


}
// Time Complexity :O(m*n)
// Space Complexity :O(n)



//using only single array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [] dp =  new int[n+1];
        for (int j=1; j<=n; j++){
            dp[j] = 999999;
        }
        for (int i=1; i <= m; i++){
            for(int j= 1; j <= n; j++){
                //case1 is available
                if(j < coins[i-1]){//till the time amount < denomination of current coin
                    //no choose case
                    dp[j] = dp[j];
                } else {
                    //no choose case snd choose
                    //amount-denomination of curr coin
                    dp[j]=Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
            }
        }
        int re = dp[n];

        if(re >= 999999) return -1;
        return re;
    }
}

 //House Rober
// Time Complexity :O(n)
// Space Complexity :O(n)
 class Solution {
     public int rob(int[] nums) {
         // null
         int [] memo = new int[nums.length];
         Arrays.fill(memo, -1);
         return helper(nums, 0, memo);
     }
     private int helper(int [] nums,int idx, int [] memo){
         //base
         if(idx >= nums.length) return 0;
         //logic
         //choose
         if(memo[idx] != -1) return memo[idx];
         int case1 = nums[idx] + helper(nums, idx+2, memo);
         //dont choose
         int case2 = 0 + helper(nums,idx + 1, memo);
         memo[idx] = Math.max(case1, case2);
         return memo[idx];

     }
 }