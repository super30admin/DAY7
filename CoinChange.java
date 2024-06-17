import java.util.Arrays;
//TC: O(m * n)
//SC: O(m * n)
// m = amount
// n = coins.length
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0){
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j = 1; j < amount + 1; j++){
            dp[0][j] = amount + 1; // amount + 1 to avoid overflow instead of Integer.MAX_VAL
        }

        for(int i = 1; i < coins.length + 1 ;i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] ,  1 + dp[i][j - coins[i - 1]]);
                }
            }
            if(dp[coins.length][amount] == amount + 1){
                return -1;
            }

        }
        return dp[coins.length][amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.stream(dp).forEach(a-> Arrays.fill(a, -2));
        return coinChangeHelper(coins, amount, 0, 0, dp);
    }

    private int coinChangeHelper(int[] coins, int amount, int index, int coinsUsed, int[][] dp){
        if(index == coins.length || amount < 0){
            return -1;
        }
        if(amount == 0){
            return coinsUsed;
        }

        int case1 = coinChangeHelper(coins, amount, index + 1, coinsUsed, dp);
        int case2 = coinChangeHelper(coins, amount - coins[index], index, coinsUsed + 1, dp);
        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }

        return Math.min(case1, case2);
    }
    public int coinChange2(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, -1);
        int ans = coinChangeHelper(coins, amount, count);
        return  ans== Integer.MAX_VALUE? -1: ans;
    }

    int coinChangeHelper(int[] coins, int amount, int[] count){
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        if(count[amount] != -1){
            return count[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){
            int res = Integer.MAX_VALUE;
            if(amount - coins[i] >= 0)
                res = coinChangeHelper(coins, amount - coins[i], count);

            if(res != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1 + res);
            }


        }

        return count[amount] = minCoins;
    }

    public static void main(String[] strs){
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5}, 11));
    }
}
