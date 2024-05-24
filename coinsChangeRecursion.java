/*
 * Approach: Recursion
 */


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        return recurse(coins, amount, 0, 0);
    }

    private int recurse(int[] coins, int amount, int index, int usedCoins){
        //base 
        if(index == coins.length || amount < 0){
            return -1;
        }
        if(amount == 0){
            return usedCoins;
        }
        //logic
        //zero or not picking the element for recursion
        int case1 = recurse(coins, amount, index + 1, usedCoins);
        //one or pick the couns used
        int case2 = recurse(coins, amount - coins[index], index, usedCoins+1);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;

        return Math.min(case1, case2);
    }
}