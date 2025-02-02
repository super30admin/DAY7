// Time Complexity: O(m+n) = O(n) where m is the amount and n is the number of coins
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode : Yes

// Approach: Dynamic Programming
// For each coin we have two choices, either choose or not choose
// If we choose this coin, value will be 1 + dp[i][j - coins[i - 1]]
// If we do not choose this coin, value will be dp[i - 1][j]

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size(), n = amount;
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        for(int j = 1; j <=n; j++){
            dp[0][j] = amount+1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                //If coin we have is greater than amount
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int ans = dp[m][n];
        if(ans >= amount+1){return -1;}
        return ans;
    }
};