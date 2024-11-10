/*
Time Complexity: Time Limit exceeded due to exponential Time complexity 2^(m+n) where m is the number
                  of elements in an array, and n is the total amount

Space Complexity: m+n as that many subproblems would be created to find the path

Did this code successfully run on Leetcode: No as time limit exceeded.

NOTE: Read "Information" file before starting with this.

Invalid cases: In exhaustive approach, if the amount becomes negative, or there are no more coins left in
               the array then it is invalid.
==========================================================================================================
In the end, we will have 3 types of leaf nodes in exhaustive approach:

1) Valid leaf node where the amount is zero.
2) Leaf node where amount is negative.
3) Leaf node where no more coins left but the amount remains eg: []^11

Among all these valid paths, we should choose the minimum path which uses minimum number of coins to form the total.

In exhaustive approach, the time complexity will be 2^(m+n), where m+n will be the height(depth) of the tree, where
m is the total number of elements in array and n will be the total we need
eg: [1, 2, 5]^11 so m = 3, n = 11 so 2^(3+11) => 2^13.

Also, space complexity in exhaustive approach will be recursive stack space, so here recursive stack space will be
(m+n) as those many recursive calls will be happening.
 */

/*
SEE 2 Solutions with minor changes like considering Integer.MAX_VALUE
 */
/*** SOLUTION 1 ***/
public class CoinChangeExhaustiveApproach
{
    //Exhaustive Approach means Recursive

    public int coinChange(int[] coins, int amount)
    {
        return helper(coins, amount, 0, 0); //this helper function will return the min no of coins needed.
    }

    private int helper(int[]  coins, int amount, int i, int coinsUsed)
    {
        /*
            i is the pointer to track in the array, and we also need to
            track the coins used.
        */

        //Base Case
        if(amount == 0)
            return coinsUsed;

        if(amount < 0 || i == coins.length) //Negative number || no coins left
            return -1;

        //Logic
        //Don't Choose
        int case0 = helper(coins, amount, i+1, coinsUsed);

        //Choose
        int case1 = helper(coins, amount-coins[i], i, coinsUsed+1);

        //If one path is valid and another is invalid, we do not want to find min
        if(case0 == -1) return case1;
        if(case1 == -1) return case0;

        //If both case0 and case1, returns the same output, choose minimum
        return Math.min(case0, case1);

    }
}

/*** SOLUTION 2 ***/
/*
Instead of
1)
    public int coinChange(int[] coins, int amount)
    {
        return helper(coins, amount, 0, 0); //this helper function will return the min no of coins needed.
    }
replace with
    public int coinChange(int[] coins, int amount)
    {
        int result = helper(coins, amount, 0, 0); //this helper function will return the min no of coins needed.
        if (result == Integer.MAX_VALUE) {
         return -1;
        }
        return result;
    }

2) In base case,

        if(amount < 0 || i == coins.length)
            return -1;

        replace with
        if(amount < 0 || i == coins.length)
            return Integer.MAX_VALUE;

3) Due to change in base case we don't need:
        if(case0 == -1) return case1;
        if(case1 == -1) return case0;
 */