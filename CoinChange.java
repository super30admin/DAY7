// This solution will make use of the tracker array that stores all the valid number of coins that can be formed in all the possibilities which helps us to reduce the number of computations as we can refer the calulated calues through the array. The tracker will get updated based on the chose or no choose case.
// Time complexity: O(m*n)
// Space Complexity: O(n+1)

public class CoinChange{
    public int coinChange(int[] coins, int amount) {
        /* return helper(0, amount, coins, 0);
         
     }
     private int helper(int index, int target, int[] coins, int numberOfCoins){
         if(index >= coins.length || target<0){
             return -1;
         }
         if(target == 0){
             return numberOfCoins;
         }
         // cases
         int case0 = helper(index+1,target, coins, numberOfCoins);
         int case1 = helper(index, target-coins[index], coins, numberOfCoins+1);
         
         if(case0 == -1) return case1;
         if(case1 == -1) return case0;
         
         return Math.min(case0, case1); */ 
         int m = coins.length;
         int n = amount;
         
         int[] tracker = new int[n + 1];
         for(int j=1; j<=n; j++){
             tracker[j] = Integer.MAX_VALUE - 1; 
         }
         for(int i = 1; i<=m; i++){
             for(int j=0; j<=n; j++){
                 if(j < coins[i-1]){
                     tracker[j] = tracker[j];
                 }
                 else {
                 tracker[j] = Math.min(tracker[j], 1 + tracker[j-coins[i-1]]);
                 }
             }
         }
         
         if(tracker[n] > amount) return -1;
         
         return tracker[n];
     }
}