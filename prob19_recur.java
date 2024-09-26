// S30 Big N Problem #19 {Medium}
// 322. Coin Change
// Time Complexity : Exponential
// Space Complexity :
// Did this code successfully run on Leetcode : No 
// Any problem you faced while coding this :
// Time Limit Excedded 

// Your code here along with comments explaining your approach
// Recursion approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        return foo(coins,amount,0,0);
    }
    
    private int foo(int[] coins, int amount, int index, int min){
        // Base case
        if(amount<0 || index>=coins.length) return -1;
        if(amount==0) return min;
        
        //Logic{Recursive binary tree}
        //not choose
        int case1=foo(coins, amount, index+1, min);
        
        //choose
        int case2=foo(coins, amount-coins[index], index, min+1);
        
        if(case1 == -1) return case2;
        else if(case2 == -1) return case1;
        
        return Math.min(case1,case2);
    }
}