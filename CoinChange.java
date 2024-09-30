//322. Coin Change

// Time Complexity : 2^m+n
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// [1,2,5] to reach 11
// first I try greedy but it will not work in all cases like [2,5,6] to reach 9
// So I try brute force or exhaustive try all possible combinations
// then i see repeaded sub problems in the tree of exhaustive so we use DP 
//then i decide what kind of tabulation we need array or matrix as we have 2 decision making parameters here coins and amount so i will choose matrix 

//exhaustive approach

// class CoinChange{
//      public int coinChange(int[] coins, int amount){

//         return helper(coins, 0, amount, 0);


//      }

//      private int helper(int[] coins, int i, int amount, int coinsUsed){

//         if(amount < 0 || i >= coins.length) return -1;// base case if amount is less than 0 or amount left array elements finished. 
//         //I can also return Integer.MAX_VALUE INSTEAd of -1 and do not need two cases below handle invalid case in coinChange method
//         if(amount == 0) return coinsUsed;

//         int case0 = helper(coins, i + 1, amount, coinsUsed);
//         int case1 = helper(coins, i, amount - coins[i], coinsUsed + 1);

//         if(case0 == -1) return case1;// if any one of the case gived -1 based on base case return the other case.
//         if(case1 == -1) return case0;


//         return Math.min(case0, case1);
//      }

//      public static void main(String args[]){
//      CoinChange cc = new CoinChange();

//      //int[] coins = {1, 2, 5}; 
//      //int[] coins = {2}; 
//       int[] coins = {1}; 
//      //int amount = 11;
//      //int amount = 3;
//      int amount = 0;

//      int result = cc.coinChange(coins, amount);

//      System.out.println(result);

//      }

// }

// DP apprach with 2D array
class CoinChange{
   public int coinChange(int[] coins, int amount){

      int m = coins.length;
      int n = amount;

      int[][] dp = new int[m +1][n +1];

      for(int j = 1; j <= n; j++){
         dp[0][j] = amount +1;// ivalid values so put like intmax 
         //to reach amount in row using 0 will be invalid
      }

      for(int i = 1; i <= m; i ++){
         for(int j = 1; j <= n; j++){
            if(j < coins[i-1]){
               dp[i][j] = dp[i-1][j];// no availability case 0 choose case
               // value comes from right above
               //TC- O(mn)
               //SC- O(mn)

            }
            else{
               dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);//both case semario, choose case and no choose
            }
         }
      }

      if(dp[m][n] > amount) return -1;

      return dp[m][n];

   //   // DP using 1D array---------------------
   // // we can optimize it with 1D array. we can rewrite the teh array 
   // //because from 2D array we only need previous row to come for new row, for coins[i-1] we can use the same value dp[j]
   //   int[] dp = new int[n +1];

   //    for(int j = 1; j <= n; j++){
   //       dp[j] = amount +1;// ivalid values so put like intmax 
   //       //to reach amount in row using 0 will be invalid
   //    }

   //    for(int i = 1; i <= m; i ++){
   //       for(int j = 1; j <= n; j++){
   //          if(j < coins[i-1]){
   //             dp[j] = dp[j];// no availability case 0 choose case
   //             // value comes from right above

   //          }
   //          else{
   //             dp[j] = Math.min(dp[j], 1 + dp[j-coins[i-1]]);//both case semario, choose case and no choose
   //          }
   //       }
   //    }

   //    if(dp[n] > amount) return -1;

   //    return dp[n];

      //--------------------------------------
}
   public static void main(String args[]){
   CoinChange cc = new CoinChange();

   int[] coins = {1, 2, 5}; 
   //int[] coins = {2}; 
    //int[] coins = {1}; 
   int amount = 11;
   //int amount = 3;
   //int amount = 0;

   int result = cc.coinChange(coins, amount);

   System.out.println(result);

   }

}
