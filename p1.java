// Time Complexity : Time complexity would be O(m+n) where m is the amount and n is the number of coins
// Space Complexity : Space complexity would be O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not figure out Math.min(m[i-1][j],1+m[i][j-c]);. Had to refer lecture


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        //Matrix to store results of number of coins required 
        int[][] m = new int[coins.length+1][amount+1];
        //Creating a dummy row
        for(int i = 1; i< amount+1;i++){
            m[0][i] = 100000;
        }

        //Traversing over every element in the matrix
        for(int i=1; i<coins.length+1; i++){
            //Getting the coin denomination for that row
            int c = coins[i-1];
            for(int j=1; j<amount+1; j++){
                //If amount is less than the coin denomination, enter the number of coins from the previous row
                if(j<c){
                    m[i][j] = m[i-1][j];
                } 
                //Else get the number of coins. Whichever is lesses out of previous row and current row
                else{
                    m[i][j] = Math.min(m[i-1][j],1+m[i][j-c]);
                }
            }
        }
        // Amount of coins will be more than max amount if it is not possible to make up the amount using the coins denomination
        if(m[coins.length][amount] < 100000) return m[coins.length][amount];
        else return -1;
    }

}