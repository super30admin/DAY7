class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)
            return 0;

        int[] minCoins = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            minCoins[i] = Integer.MAX_VALUE;

            for(int coin : coins){
                if(coin <= i && minCoins[i - coin] != Integer.MAX_VALUE)
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
            }
        }
        if(minCoins[amount] == Integer.MAX_VALUE)
            return -1;
        return minCoins[amount];
        
    }
}