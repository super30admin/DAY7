// Time Complexity : O(n*amount) 
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>
 
using namespace std;

class Solution {
public:
    // int helper(vector<int>& coins, int amt, int ind, vector<vector<int>>& dp) {
    //     if (amt == 0 ) return 0;
    //     if (amt <0 || ind >= coins.size()) return 99999;

    //     if (dp[ind][amt] !=-1) return dp[ind][amt];
    //     // choose
    //     int c = 1+helper(coins, amt-coins[ind], ind, dp);
    //     // not choose
    //     int n = helper(coins, amt, ind+1, dp);
    //     return dp[ind][amt] = min(c, n);
    // }
    int coinChange(vector<int>& coins, int amount) {
        int m =coins.size();
        int n = amount;
        vector<vector<int>> dp(m+1, vector<int>(n+1,0));
        // int res = helper(coins, n, 0, dp);
        // if (res==99999) return -1;
        // return res;
        dp[0][0] = 0;
        for (int i = 1; i<=m; i++){
            dp[i][0] = 0;
        }
        for (int i = 1; i<=n; i++) {
            dp[0][i] = 99999;
        }

        for (int i=1; i<=m;i++) {
            for (int j=1; j<=n; j++) {
                if (coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
            }
        }
        if (dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
};