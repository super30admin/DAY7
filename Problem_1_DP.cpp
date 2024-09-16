//Space Complexity: O(NM), where n is size of coins and m is amount.
//Time Complexity: O(n), where n is the length of the array.
//Executed successfully  on leetcode.

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size()==0) return 0;
        int dp[coins.size()+1][amount+1];
        for(int i=0; i<coins.size()+1; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i< amount+1; i++){
            dp[0][i] = 9999;
        }
        
        for(int i=1; i<coins.size()+1; i++){
            for (int j = 1; j<amount+1; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = std::min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }
        if(dp[coins.size()][amount]>=9999) return -1;
        else return dp[coins.size()][amount];
    }

};