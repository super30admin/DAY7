// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//Approach: We will use tabulation here and code on the base of recursive approach
//we will try out each choose and nochoose case and create a 2d dp matrix for it
//we will initilize the fist with infinity and will go through the nxt row 1by1 and fill
//everything by comparing and taking the minimum
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;

        vector<vector<int>> dp(m + 1, vector<int>(n + 1));

        //setting initial row ith infinity
        dp[0][0] =0;
        for(int j=1;j<=n;j++){
            dp[0][j] = 99999;
        }
        //going through the next row
        for(int i =1;i<=m;i++){
            for(int j=0;j<=n;j++){
                 if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                 } 
                 else{
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                 }
            }
        }
        if(dp[m][n]>=amount+1)return -1;
        return dp[m][n];
    }
};