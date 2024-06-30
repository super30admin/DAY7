//time complexity: 0(M*N)
//space complexity: O(N)

class CoinChange {


    //*******Exhaustive approach */
    // public int coinChange(int[] coins, int amount) {
    //  int re = helper(0, amount, coins);
    //  if (re == 99999) return -1;
    //  else return re;   
    // }

    // public static int helper(int i, int amount, int[] coins){
    // if(amount==0) return 0;
    // if( i == coins.length || amount<0) return 99999;
    //     //no choose
    //       int case1 = helper(i+1, amount, coins);
    //     //choose
    //      int case2 = 1+ helper(i, amount-coins[i], coins);
    //      return(Math.min(case1, case2));
    // }


    /**
     * ******Using 2D array
     */
//     public int coinChange(int[] coins, int amount) {
//             int m = coins.length+1;
//             int n = amount+1;
//             int[][] dp = new int[m][n];
//          for(int j=1;j<n;j++){
//             dp[0][j] = 999999;
//          }
//          for(int i=1;i<m;i++){
//             for(int j=1;j<n;j++){
//                 if(j<coins[i-1]){
//                     dp[i][j] = dp[i-1][j];
//                 } else{ 
//                     dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
//                 }
//             }
//          }
//          if(dp[m-1][n-1] == 999999) return -1;
//          else return dp[m-1][n-1];
// }


//******Optimised space complexity */
    public int coinChange(int[] coins, int amount) {
        int m = coins.length + 1;
        int n = amount + 1;
        int[] dp = new int[n];

        for (int j = 1; j < n; j++) {
            dp[j] = 999999;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        if (dp[n - 1] == 999999) {
            return -1; 
        }else {
            return dp[n - 1];
        }

    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1, 2, 5};
        System.out.println(obj.coinChange(coins, 11));
    }

}
