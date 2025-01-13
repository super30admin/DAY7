// Time Complexity : O(m*n) where m be number of coins and n be amount
// Space Complexity : O(m*n) where m be number of coins and n be amount for using dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Using dp array to fill noumber of coins to meet intermediate amount then final amount
no pick case: considering previous nos of coins used
Pick case: minimum between previous nos of coins and subtracting coin value from intermediate amount 
and checking respective column*/
class Solution {
public: 
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        if(n==0){
            return -1;
        }
        //initializing empty vector dp
        vector<vector<int>> dp;
        
        //resizing dp rows to number of coins+1(accomodate 0)
        dp.resize(n+1);

        //resizing dp columns to number of amount+1(accomodate 0)
        for(int i=0; i<n+1; i++){
            dp[i].resize(amount+1);
        }

        //all columns filled with infinity(invaild) except first as it has 0
        for(int j=1; j<amount+1; j++){
            dp[0][j] = amount+1;
        }

        //firstcolumns of all rows filled with 0
        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }

        //logic for filling up rest
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(j<coins[i-1]){   //in coins array i is one less.
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1);  
                }
            }
        }
        //answer is last cell of 2D vector(used all coins and total amount)
        if(dp[n][amount] == amount+1){
            return -1;
        }
        return dp[n][amount];
    }
};