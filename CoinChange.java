/**
 * Time Complexity: O(n*m) where n =  denomination, m = amount
 * Space Complexity : O(m) where m = amount
 * Approach : Bottom-up 
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length==0) return -1;
        int max = amount + 1;
        int[] dp = new int[amount+1];
               
        for(int i=0;i<dp.length;i++)
            dp[i] = max;
        
        dp[0] = 0;
        
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
 
        if(dp[amount]<=amount) return dp[amount];
        else return -1;
        
        
    }

    public static void main(String args[]){
        CoinChange obj = new CoinChange();
        int[] myArr = new int[]{1,2,5};
        int amount = 11;
        System.out.println(obj.coinChange(myArr, amount)+" coins needed minimum");
    }
}