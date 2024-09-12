class Solution {
    public int coinChange(int[] coins, int amount) {
        
      //edge
        if(coins== null || coins.length==0) return 0;
     int dp[][] = new int[coins.length+1][amount+1]; //extra row and column added ie dummy 0 row column
        int m = dp.length; //amount  counter for row
        int n = dp[0].length; //no of coins  counter for col
       /* for(int i=0;i<n;i++ ){  //first col all rows o
             dp[i][0] = 0;
        }*/
        for(int i=1;i<dp[0].length;i++){
             dp[0][i] = 9999; //first row all columns infinete
        }
    //  case1 : not choosing coin[i-1] because we started from 0 hence current value will be i-1
      
       for(int i=1;i<m;i++ ){
           for(int j=1;j<n;j++ ){
                if(j<coins[i-1]){   //amount less than denomination
                    dp[i][j] = dp[i-1][j];  //not choosing case    
                }
                
                   //else case
                 //   int case1 = dp[i-1][j]; //not choosing denomination
                   // int case2 = dp[i][j-coins[i-1]; //choosing from same row by moving coin denomination back
                   // dp[i][j] = Math.min(case1,case2);}
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }    
                                      
           }
       }
      int  result = dp[m-1][n-1];
        if(result == 9999) return -1;
        return result;
    }}
/*
Time complexity : O(m x n)
Space complexity : O(m x n) making dp matrix
*/
