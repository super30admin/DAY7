/***
Approach- Using DP
*1. Create a 1D array and initialize row=0 and column=(1 to n) with amount+1
*2. Choose coin one by one and calculate the no of coins needed to make amount from 0 to given amount
*3. Take min between if we don't the pick current coin and if we pick the current coin
 * TC - O(m*n), SC - O(n)
 ***/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0)
            return -1;

        int dp[] = new int[amount+1];

        //Fill 1st row with greatest amount i.e amount+1

        for(int j =1; j < amount+1; j++) {
            dp[j] = amount+1;
        }

        for(int coin : coins) {
            for(int j = coin; j <= amount; j++) {
                //Take min coins between if we don't pick current coin and if we pick the current coin
                dp[j] = Math.min(dp[j], dp[j-coin] +1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

}
