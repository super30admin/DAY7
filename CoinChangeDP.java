// Time complexity: O(n * m): n-> length of coins array, m -> amount : as it is a 2d array.
// Space complexity: O(n * m)


class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return 0;

        int dp[][] = new int[coins.length + 1][amount + 1]; // coins.length+1 to account for //the dummy row and amount + 1 for the 0 column.

        // initialize dummy column

        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] = 0;
        }

        // initializing dummy row
        for(int i = 1 ; i < dp[0].length ; i++){
            dp[0][i] = 9999; // not taking MAX_VALUE of int to prevent overflow.
        }

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){

                if(j < coins[i-1]){ // coins[i-1] because it is at i-1 in the coins array to get the actual coin value
                    dp[i][j] = dp[i-1][j]; // take it from above // zero case: not choosing the current coin
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1); // +1 to account for choosing the current coin
                }

            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];

        if(result >= 9999) return -1; // no coins found to make the change;
        return result;


    }
}
