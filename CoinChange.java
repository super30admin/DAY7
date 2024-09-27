public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        //create dp array
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        //first column
        for(int i = 0; i <= m; i ++){
            dp[i][0] = 0;
        }
        //top row except first element
        for(int j = 1; j  <= n; j++){
            dp[0][j] = 99999;
        }

        // dp matrix filling
        for(int i = 1; i <= m; i++){
            for(int j=1; j <= n; j++){

                //amount < denomination, check previous row
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                // when selecting, go back in columns by denomination levels
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j - coins[i-1]]);
                }
            }
        }
        int minimumCoins = dp[m][n];
        if(minimumCoins > amount) return -1;
        else return minimumCoins;
    }

    public static void main(String[] args){
        CoinChange object = new CoinChange();

        int [] givenCoins = {1,2,5};
        int target = 11;

        int result = object.coinChange(givenCoins, target);
        System.out.println("Minimum number of coins requited to reach target amount: " + result);
    }
}

// recursion base
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        //null
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int idx, int minCoins){

        //base
        // target reached
        if(amount == 0) return minCoins;
        // amount going negative or index out of bounds
        // amount, idx - deciding variables
        if(amount < 0 || idx == coins.length) return -1;

        //logic

        //not choose
        int noChoose = helper(coins, amount, idx+1, minCoins);

        //choose
        int choose = helper(coins, amount - coins[idx], idx, minCoins + 1 );

        // get the other if anyone is negative
        if(noChoose == -1) return choose;
        if(choose == -1) return noChoose;

        // get minimum if both are non-negative
        return Math.min(noChoose, choose);


    }
}
 */
