// Time Complexity :O(n*C) (n amount and c is umber of coins )
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class  Problem1 {

    public int coinChange(int[] coins, int amount) {
         int n = amount;

         int[] dp= new int [n+1];

         for(int j=1; j<=n; j++){
             dp[j]=amount+1;
         }

         for(int i = 1; i<=coins.length; i++){
             for(int j=0; j<=n; j++){
                 if(j>=coins[i-1]){
                     dp[j]=Math.min(dp[j], 1+dp[j-coins[i-1]]);
                 }
             }
         }
         if(dp[n]>= amount+1){
             return -1;
         }
        return dp[n];
    }

    public static void main(String args[]) {
            Problem1 problem1 = new Problem1();
        int[] coins={1,2,5};
        int amount=11;
        System.out.println("Output "+problem1.coinChange(coins, amount));

    }
}
