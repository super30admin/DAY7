class totalCoinChange{

    public int coinChange(int[] nums, int amount){
        if(nums == null || nums.length ==0) return 0;
        int[][] dp = new int[nums.length +1][amount+1];

        for(int i=1; i<amount+1;i++){
            dp[0][i] = amount + 1;
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j =1; j<amount+1;j++){
                if(j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-nums[i-1]]);
                }
            }
        }
        if(dp[nums.length][amount] == amount+1) return -1;
        return dp[nums.length][amount];
    }

    public static void main(String[] args) {
        totalCoinChange tcc = new totalCoinChange();
        int[] nums = {1,2,5};
        int amount = 11;
        System.out.println(tcc.coinChange(nums, amount));
    }
}