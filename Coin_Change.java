// Time Complexity :O(2^n)
// Space Complexity :O(n^2) arrays
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I plan to use dynamic programming and submit the assignment again after today's class


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }
    
    public int helper(int[] coins, int amountLeft, int coinIndex, int totalCoins){
        
        if(amountLeft<0 || coinIndex>coins.length-1)
            return -1;
        
        if(amountLeft == 0)
            return totalCoins;
        
        int coinsScenario1 = helper(coins, amountLeft, coinIndex+1, totalCoins);
        int coinsScenario2 = helper(coins, amountLeft - coins[coinIndex], coinIndex, totalCoins+1);
        if(coinsScenario1 == -1)
            return coinsScenario2;
        if(coinsScenario2 == -1)
            return coinsScenario1;
        
        return Math.min(coinsScenario1, coinsScenario2);
    }
}