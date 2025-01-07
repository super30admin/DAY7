// Time Complexity : O(m*n) -> for dp solution
// Space Complexity : O(m*n) -> for dp solution
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No
class Problem1 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        //Approach1 : GO greedy -> greedy will fail because what if coins = [1,2,5] and amount = 6
        //Approach2 : Recursive(Exhaustive) -> here we'll make our decision on 2 choice either choose / not choose the coin denoted by 0 and 1. and we'll get TLE with this.
        //return helperForRecursive(coins,amount,0,0);

        //Approach 3 : using dp to store the value for already occurred sub problem.
        return helperForDp(coins,amount);
    }

    private int helperForDp(int[] coins, int amount){
        //approach 3 : if exhaustive fail use dp to store the underlying same sub problem
        int[][] dp  = new int[coins.length+1][amount+1]; // why +1 because the index start from 0 we need till coins 11 and for amount there is amount 0 also.

        //fill the 0th row (coint = 0 and amount from 1 -> 11) with infinity.
        for(int i = 1;i<amount+1;i++){
            dp[0][i] = amount+1; //which is infinity.
        }
        for(int i = 1;i<coins.length+1;i++){
            for(int j = 1;j<amount+1;j++){
                if(coins[i-1]>j){//if the amount is less than the current coint we're not gonna choose that coin and look up right above
                    dp[i][j] = dp[i-1][j];
                }
                else{//if the amount is = > coin  then min between if we choose or if we don't choose.
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    //why +1 because in that case we're choosing 1 coin and what is [j-coins[i-1]] => current amount - coin back (coin arrays has 3 coin start from 0 index but our generated i has +1 value so we're going -1 to find the actual coin).
                }
            }
        }
        //check the last row and last col for the result
        if(dp[coins.length][amount] ==  amount+1){//which is infinity
            return -1;
        }
        return dp[coins.length][amount];
    }

    private int helperForRecursive(int[]coins, int amount, int coinIndex,int coinUsed){
        //base
        //There are 2 base case where we return -1 when we don't have any coin left or the amount becomes -ve.
        if(coinIndex > coins.length-1 || amount < 0){
            return -1;
        }
        //if the amount become 0 it means we've reached to the solution return coinUsed.
        if(amount == 0){
            return coinUsed;
        }

        //functionality.
        //not use the current coin.
        int case1 = helperForRecursive(coins,amount,coinIndex+1,coinUsed);

        //use the coin.
        int case2 = helperForRecursive(coins,amount-coins[coinIndex],coinIndex,coinUsed+1);

        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1,case2);
    }
}