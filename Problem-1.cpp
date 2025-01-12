// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution
{
public:
    int coinChange(vector<int> &coins, int amount)
    {
        if (coins.empty())
        {
            return -1;
        }

        // to store the count for different ways to make up for the amount
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1));

        // initialize for 0th column for each col
        for (int i = 0; i < dp.size(); i++)
        {
            dp[i][0] = 0;
        }

        // intialize to 1 since 0 amount can be collected with 0 coins
        // irrespective of the denimination of the coin
        for (int i = 1; i < dp[0].size(); i++)
        {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i < dp.size(); i++)
        {
            for (int j = 1; j < dp[i].size(); j++)
            {
                // coin denomination is greater than the amount
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    // coin denomination is less than or equal to the amount
                    // then add to the total # of ways
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        // if unable to sum up to the amount with the provided coins
        if (dp[coins.size()][amount] == amount + 1)
        {
            return -1;
        }

        return dp[coins.size()][amount];
    }
};