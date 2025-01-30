// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * 
 * We used dp and create 2 d array as we have 2 decision variables.
 * If amount is 0 then coins are not used so input 0.
 * If coins can be found to get that amount then return max integer, so input max integer for coins of denomination 0.
 * At any location in the matrix, number of coins = minimum of (1+dp[i][j-coins[i-1]](denomination chosen), dp[i-1][j](denomination not chosen).
 * We return dp[m][n] because we want number of coins considering all coins and total amount given.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m= coins.length;
        int n= amount;
        int[][] dp=new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            dp[0][j]=99999;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1]>j){
                    //0 case : denomination greater, amount smaller
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                
            }
        }
        
        int re = dp[m][n];
        if(re>=99999){
            return -1;
        }
        return re;

    }

}


/*
public class CoinChange {
    //recursion
  public int coinChange(int[] coins, int amount) {
    int re=helper(coins,0,amount);
    if(re>=99999){
        return -1;
    }
    return re;
  }

  private int helper(int[] coins, int idx, int amount){
    //base
    if(amount==0){
        return 0;
    }
    if(amount<0 || idx==coins.length){
        return 99999;
    }
    //case 1 we choose
    int case1= 1+ helper(coins,idx,amount-coins[idx]);
    //case 2 we dont choose
    int case2= helper(coins,idx+1,amount);
    return Math.min(case1,case2);
  }
}
*/
