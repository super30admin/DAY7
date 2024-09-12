//Time Complexity O(coins.size()*amount)
//Space Complexity O(coins.size()*amount)

// Problem successfully compiled on leetcode
// Lot of problems faced while figuring out the logic


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (coins.size()==0) return 0;
        
        int dp[coins.size()+1][amount+1];
        
        for(int i=0; i<coins.size()+1;i++)
        {
            dp[i][0]=0;
        }
        for(int j=1;j<amount+1;j++)
        {
            dp[0][j]=amount+1;
        }
        
        for(int i=1;i<coins.size()+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        if(dp[coins.size()][amount]>amount)
        {
            return -1;
        }
        
        return dp[coins.size()][amount];
        
        
    }
};