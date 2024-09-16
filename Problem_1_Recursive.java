// Time complexity - O(2^n)
// Space complexity - ?

// Implemented using recurion by making choice of selecting of a coin or not.


class Solution {
   public int coinChange(int[] coins, int amount) {
       return helper(coins, amount, 0, 0);
   }

   public static int helper(int [] coins, int remainingAmount,int coinIndex, int currentNumberOfCoins){
   
    // Base case
       if (remainingAmount < 0 || coinIndex > coins.length - 1) return -1;
       if (remainingAmount == 0) return currentNumberOfCoins;
       
    // Logic
       // Case 1 Don't choose the coin 
       int noOfCoinsCase1 = helper(coins, remainingAmount, coinIndex + 1, currentNumberOfCoins);

       // Case 2 Choose the coin
       int noOfCoinsCase2 = helper(coins, remainingAmount - coins[coinIndex], coinIndex, currentNumberOfCoins + 1);

      if (noOfCoinsCase2 == -1) return noOfCoinsCase1;
      if (noOfCoinsCase1 == -1) return noOfCoinsCase2;
      else return Math.min(noOfCoinsCase1, noOfCoinsCase2);

   }
}
