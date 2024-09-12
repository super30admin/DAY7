/**
 * Recursive solution
 */

class CoinChangeRecursive {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;


        return helper(coins, amount, 0, 0);


    }

    private int helper(int[] coins, int amount, int index, int min){

        //base case
        if(amount == 0) return min;

        // if amount becomes negative or index becomes equal to the length of the array. (out of bounds).
        if(amount < 0 || index == coins.length) return -1;

        //recursive case

        // pick coin
        int case1 = helper(coins, amount - coins[index], index, min + 1);

        // leave coin

        int case2 = helper(coins, amount, index + 1 , min);

        if(case1 == -1) return case2;
        if(case2 == -1) return case1;

        // return the minimum value from the amount returned by case 1 and case2.
        return Math.min(case1, case2);

    }
}
