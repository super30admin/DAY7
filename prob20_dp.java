// S30 Big N Problem #20 {Easy}
// 198. House Robber
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DP matrix
// for not choosen (case 0) find max of previous choosen and not choosen values
// for choosen case, select not choosen from previous and add corresponding value
// house sum (choose) 0 1
// 1                  0 1
// 3                  1 3
// 5                  3 6-> answer
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        
        // First Solution
        // Space O(n) and Time O(n)
        // int [][] dp=new int [nums.length][2];
        // dp[0][0]=0;
        // dp[0][1]=nums[0];
        // for(int i=1; i<nums.length;i++){
        //     for(int j=0;j<2;j++){
        //         if(j==0){ //not choosen
        //             dp[i][j]=Math.max(dp[i-1][0],dp[i-1][1]);
        //         }else{ //choosen
        //             dp[i][j]=dp[i-1][0] + nums[i];
        //         }
        //     }
        // }
        // return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
        
        
        // Second Solution
        // Space O(1) and Time O(n)
        int choosen=0;
        int notchoosen=0;
        
        for(int i=0; i < nums.length; i++){
            int temp = choosen;
            choosen = notchoosen + nums[i];
            notchoosen = Math.max(temp,notchoosen);
        }
        return Math.max(choosen,notchoosen);   
    }
    
}
