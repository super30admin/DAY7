// Time Complexity : O(n*k)=> n is number of coins and k is the amount
// Space Complexity : O(n^k) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int dp[coins.size()+1][amount+1];

        // Fill first column
        for(int i=0; i<=coins.size(); i++)
            dp[i][0] = 0;

        // Fill first row
        for(int i=1; i<=amount; i++)
            dp[0][i] = amount+1;

        
        for(int i=1;i<=coins.size();i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j - coins[i-1] < 0)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[coins.size()][amount] > amount)
            return -1;
        return dp[coins.size()][amount];
    }
};