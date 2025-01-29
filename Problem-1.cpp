//https://leetcode.com/problems/coin-change/description/
// Time Complexity : O(n*m) where n is the amount and m is the length of the coins array
// Space Complexity : O(n) where n is amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Declare an array(dp) of size amount+1 and initialize it with INT_MAX except for 0th position whose value is 0.
// For each value upto to the amount, calculate the min number of coins requred, start with no coins for 0.


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, INT_MAX);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(auto c : coins){
                if(i-c >=0 && dp[i-c] != INT_MAX) dp[i] = min (dp[i], 1+dp[i-c]);
            }
        }
        return (dp[amount] == INT_MAX) ? -1: dp[amount];
    }
};