/*Recursion Approach:
Base cases: If the amount becomes 0, return the number of coins used. If the amount is negative or there are no more coins to consider, return -1.
The result is the minimum of the cases where the current coin is excluded (case0) or included (case1).

Time Complexity: Exponential time complexity due to exploring all possibilities.
Space Complexity: O(m) for the recursive call stack.

Dynamic Programming (DP) Approach:

Create a 2D DP array dp, where dp[i][j] represents the minimum number of coins needed to make amount j using the first i coins.
Initialize the first row of dp with n+1 for amounts greater than 0, indicating an invalid value.
Fill in the DP array by considering both options: excluding the current coin (dp[i-1][j]) and including it (1 + dp[i][j - coins[i-1]]).
The result is dp[m][n], where m is the number of coins and n is the target amount. If it remains n+1, there is no valid combination.

Time Complexity: O(m * n), where m is the number of coins and n is the target amount.
Space Complexity: O(m * n) for the 2D DP array.
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
//recursion approach
    // int helper(vector<int>& coins, int amount, int index, int coinsUsed) {
    //     if(coins.size()==index||amount<0){
    //         return -1;
    //     }
    //     if(amount == 0)return coinsUsed;

    //     int case0=helper(coins,amount,index-1, coinsUsed);
    //     int case1=helper(coins,amount-coins[index],index, coinsUsed+1);
    //     if(case0==-1)return case1;
    //     if(case1==-1)return case0;
    //     return min(case0,case1);
    // }
//dp
    int coinChange(vector<int>& coins, int n) {
        int m=coins.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for(int j=1;j<=n;j++){
            dp[0][j]=n+1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]==n+1)return -1;
        return dp[m][n];
    }
};

            
        
        