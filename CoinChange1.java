// Approach 1: Form a Binary decision tree by choosing coins and no choosing coins.
// Time : O(2^ (Target/min(no of coins)))
// Space: O(Target/min(no of coins))
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins , amount , 0 , 0);
    }
    public static int helper(int[] coins , int remainingAmount,int coinIndex, int currentNumberOfCoins){
        if(remainingAmount < 0 || coinIndex>coins.length-1) return -1; // invalid branch 
        if(remainingAmount == 0){
            return currentNumberOfCoins;
        }
        // case 1: dont choose the coin
        int noOfCoinsCase1 = helper(coins,remainingAmount,coinIndex+1,currentNumberOfCoins); // currentNumberCoins - No Of Coins used

        // case 2: Choose the coin
        int noOfCoinsCase2 = helper(coins,remainingAmount-coins[coinIndex],coinIndex,currentNumberOfCoins+1);
        
        if (noOfCoinsCase2 == -1) return noOfCoinsCase1;
        if (noOfCoinsCase1 == -1) return noOfCoinsCase2;

        else return Math.min(noOfCoinsCase1,noOfCoinsCase2);
    }
}


// Approach: Build a DP array
// Time: O(Target*n)
// Space: O(Target*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1]; // O to target
        for(int i=0;i<coins.length;i++){
            // fill first column of DP
            dp[i][0] = 0;
        }
        for(int j=1;j<=amount;j++){
            // fill first row of DP
            dp[0][j] = 99999;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){
                // if your target < coin denomination then it is useless
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }

        int result = dp[coins.length][amount];
        if(result>=99999) return -1;
        else return result;
    }
}