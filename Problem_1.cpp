// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 322. Coin Change
// Approach: Dynamic Programming
// Time Complexity: O(m x n)

class Solution
{
public:
    int coinChange(vector<int> &coins, int amount)
    {

        // Base Case to check if no coins are present
        if (coins.empty() || coins.size() == 0)
        {
            return -1;
        }

        // Init DP array
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1, 0));

        // Init DP array values
        for (int j = 1; j < amount + 1; j++)
        {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < coins.size() + 1; i++)
        {
            for (int j = 1; j < amount + 1; j++)
            {

                if (j < coins[i - 1])
                {
                    // Case 0 - Don't Pick
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    // Case 1 - Pick
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }

            if (dp[coins.size()][amount] == amount + 1)
            {
                return -1;
            }
        }

        return dp[coins.size()][amount];
    }
};