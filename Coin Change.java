/*
Time Complexity: O(m*n).m is the number of rows and n is number of columns
Space Complexity : O(m*n)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0||coins==null){
            return -1;
        }
        //declare the 2d array with coins.length rows and amount cols
        int dp[][] = new int[coins.length+1][amount+1];//+1 is added as the last value is also taken into consideration
       
        //fill the first row of the array with max value 
        for(int i=1;i<dp[0].length;i++){
             dp[0][i] = amount+1;//Integer.MAX is not used as when using +1 wiould create overflow
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //check if the coin value is grater than the amount if so set to max value
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                //otherwise choose the min value
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        //when the last value is determined check if its max value, if so returnn -1
        if(dp[dp.length-1][dp[0].length-1]==amount+1){
            return -1;
        }
        //otherwise return the last element in the array
        else{
            return dp[dp.length-1][dp[0].length-1];
        }
    }
}