// Time Complexity : O(m*n) m : points length n: amt
// Space Complexity : dp array O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

/*
base case is inf which for us is amt+1
Tabulation if is when cant use coin else is min no of coins needed
 */

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length==0){
            return -1;
        }
        int [][] dp = new int[coins.length+1][amount+1];
        for(int j=0;j<amount+1;j++){
            dp[0][j]=amount+1;
        }
        for(int j=1;j<amount+1;j++){
            dp[0][j]=amount+1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
            if(dp[coins.length][amount]==amount+1){
                return -1;
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(coins,amount));
    }
}