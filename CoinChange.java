// Time Complexity : O(m*n) => As we are creating a 2D matrix and travesing through all the rows(m) and all the columns(n)
// Space Complexity : O(m*n) => As we are storing the result in the 2D matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Missed out on dp[coins.length][amount] == amount+1

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Create a 2D matrix with rows storing all the coins and columns formed using amount. Then calculated value for each cell by checking the min between the value in the prev row and the current row.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length+1][amount+1];

        for(int i=0; i<amount+1;i++){
            dp[0][i] = amount+1;
        }

        for(int i =1; i<=coins.length; i++){
            for(int j = 1; j<=amount; j++){

                if(j - coins[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], (dp[i][j-coins[i-1]]+1)); //We are adding +1 as we are adding that coin as well as using other coins to reach the target amount
                }
            }
        }

        if(dp[coins.length][amount] == amount+1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}

//This solution used 0-1 recursion approach

// class Solution {
//     public int coinChange(int[] coins, int amount) {

//     return numberOfCoins(coins, amount, 0, 0);

//     }

//     private int numberOfCoins(int[] coins, int amount, int index, int coinsUsed){

//         if(amount < 0 || index == coins.length){
//             return -1;
//         }

//         if(amount == 0){
//             return coinsUsed;
//         }

//         int case0 = numberOfCoins(coins, amount, index+1, coinsUsed);
//         int case1 = numberOfCoins(coins, amount - coins[index], index, coinsUsed+1);

//         if(case0 == -1){
//             return case1;
//         }

//         if(case1 == -1){
//             return case0;
//         }
//         return Math.min(case0, case1);
//     }
// }


