//TC: O(m) -> m=number of houses
//SC: O(1)
//Approach: dp[i][j] represents maximum amount that can be robbed from first i houses and j is the contional check for robbing adjacent houses (0 -> house cant be robbed, 1-> house can be robbed). 

class Solution {

    //O(m)
    public int rob(int[] nums) {
        int m = nums.length+1;
        int[] dp  = new int[2];

        int prev=0;
        for (int i=1;i<m;i++){
            prev = dp[0]; 
            dp[0] = dp[1];
            dp[1] = Math.max(dp[0], nums[i-1] + prev);        
        }

        return dp[1];
    }

    public int rob2DArraySolution(int[] nums) {
        int m = nums.length+1; int n = 2;
        int[][] dp  = new int[m][n];

        for (int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) dp[i][j] = dp[i-1][j+1];
                else dp[i][j] = Math.max(dp[i-1][j], nums[i-1] + dp[i-1][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}