TC --> O(n) --> n : coins length
SC --> O(n)
class Solution {
    public int rob(int[] nums) {
       int[][] dp = new int[nums.length][2];  
       dp[0][0] = 0;
       dp[0][1] = nums[0]; 
       for(int i =1; i<nums.length; i++){
        for(int j =0; j<2; j++){
          if(j == 0){
            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]);
          }else{
            dp[i][j] = dp[i-1][j-1] + nums[i];
          }           
        }
       }
       return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}