// ## Problem (https://leetcode.com/problems/coin-change/)

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

//Bruteforce approach
//Brute Force Approach Using Recursion
//This approach has repeated subproblem and answer to those are calculated seperately in every iteration
//Problem with this approach is time limit exceed as there are so many calls and as we are not storing the outputr of the subproblems it is calling them again and again. 
//Complexity of this will be exponential
// Space Complexity : I am not sure as there will be recursion calls
class Solution {
    public int coinChange(int[] coins, int amount) {
        //Base Condition check
        if(coins==null || coins.length==0){
            return -1;
        }
        return recurse(coins,amount,0,0);
    }
    //Recursion Function - Here we are doing 0-1 recusrsion that means either we will pick that coin or we will not pick it
    private int recurse(int[] coins, int amount,int index,int coinsUsed){
        //Base condition
        if(index==coins.length || amount<0){
            return -1;
        }
        if(amount==0){
            return coinsUsed;
        }
        //Logic
        //Zero call
        int case1=recurse(coins,amount,index+1,coinsUsed);

        //One call
        int case2=recurse(coins,amount-coins[index],index,coinsUsed+1);
        //Condition
        if(case1==-1){
            return case2;
        }
        if(case2==-1){
            return case1;
        }
        //At the end we will return the minimum of case1 and case2 
        return Math.min(case1,case2);

    }
}


//DP approach
//The above time limit exceed problem is taken care off in this approach.
//In this approach we are creating an 2-D array in which we are storing the answer for the subproblems and further we are using it
// Time Complexity O(n2)
//Space Complexity: I am not sure
class Solution {
    public int coinChange(int[] coins, int amount) {
        //Base condition check
        if(coins==null || coins.length==0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        //Initialise an 2-d array
        //We are initialising it coins.length+1][amount+1] because we are storing a dummy 0 row and 0 column so that we have a base for further calculations and we don't need to handle the first iteration seperately
        int[][] dp=new int[coins.length+1][amount+1];
        //The 0th row we are initialising it with infinity i.e in this case amount+1 because if we do Integer.Max_Value and if we do +1 then it will ibe an overflow. So to handle that we are considering infinity as amount+1
        for(int j=1;j<amount+1;j++){
            dp[0][j]=amount+1;
        }
        //we will start our loop from i=1 & j=1 as rest others are filled
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        //If at the last row amd column we get infinity i.e in this case amount+1 then we will return -1 else we will return last [row][column]
        if(dp[coins.length][amount]==amount+1){
            return -1;
        }
        else{
            return dp[coins.length][amount];
        }
        
            
        
    }
}