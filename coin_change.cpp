// Brute force : Explore all possible solutions
// Time complexity : 2^n where n is number of coins
// Space complexity : O(1) not counting stack space required for recursion

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        int total_coins = helper(coins, 0, amount);

        if(total_coins >= 10000)
        {
            return -1; 
            // we did not find any valid paths
        }

        return total_coins;
        
    }

    int helper(vector<int>& coins, int idx, int amount)
    {
        // base condition
        if(amount < 0 || idx >= coins.size())
        {
            return 10000; // return a large number
        }

        if(amount == 0)
        {
            return 0;
        }

        // choose 

        int c1 = 1 + helper(coins, idx, amount - coins[idx]);

        // not choose

        int c2 = helper(coins, idx+1, amount);

        return min(c1,c2);
    }
};



// DP solution - 2d array 
// Time complexity : O(mn)
// space complexity: O(mn) where m is coins.size() and n is amount

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(coins.size() + 1, 
                                vector<int>(amount+1, numeric_limits<int>::max() - 1000));

        // fill first row - coin 0 and amount whatever with infinity
        // since there are no possible ways to make any amount with coin of value 0

        // fill first column - amount 0 for whatever valuaton of coin to be 0
        // since we need 0 coins of any value to make amount 0
        for(int coin_idx = 0; coin_idx <= coins.size(); coin_idx++)
        {
            dp[coin_idx][0] = 0;
        }

        for(int coin_idx = 1; coin_idx <= coins.size(); coin_idx++)
        {
            for(int amt = 1; amt <= amount; amt++)
            {
                int idx_to_check_for_prev_amt = amt - coins[coin_idx -1];
                if(idx_to_check_for_prev_amt < 0)
                {
                    dp[coin_idx][amt] = dp[coin_idx - 1][amt];
                }
                else
                {
                    dp[coin_idx][amt] = min(dp[coin_idx - 1][amt], 
                                            1+dp[coin_idx][idx_to_check_for_prev_amt]);
                }

            }
        }

        // for(int i = 0; i <= coins.size(); i++)
        // {
        //     for(int j = 0; j <= amount; j++)
        //     {
        //         cout << dp[i][j] << "  ";
        //     }
        //     cout << "\n";
        // }

        return dp[coins.size()][amount]  >= numeric_limits<int>::max() - 1000 ? -1 : dp[coins.size()][amount];
    }
};


// DP - 1D array
// Time complexity - O(mn) where m is coins.size() and n is amount
// space complexity - o(n) where n is amount

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> dp(amount+1, numeric_limits<int>::max() -1000);
        dp[0] = 0;

        for(int coin_idx = 0; coin_idx < coins.size(); coin_idx++)
        {
            for(int amt = 1 ; amt <=amount; amt++)
            {
                int idx_to_check_for_prev_amt = amt - coins[coin_idx];
                if(idx_to_check_for_prev_amt < 0)
                {
                    dp[amt] = dp[amt];
                }
                else
                {
                    dp[amt] = min(dp[amt], 1+dp[idx_to_check_for_prev_amt]);
                }
            }

        }
        
        return dp[amount] >= numeric_limits<int>::max() - 1000? -1 : dp[amount];

    }
};