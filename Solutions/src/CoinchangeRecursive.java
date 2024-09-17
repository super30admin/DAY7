
// Time Complexity :O(mx2^2)
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class CoinchangeRecursive {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount, 0, 0);
    }

    public int helper(int[] coins, int amount, int i, int min){
        //Base
        if (amount<0 || i>coins.length-1) return -1;
        if (amount==0) return min;


        //Choose coin
        int case1 = helper(coins,amount-coins[i],i,min+1);

        // Not choose coin

        int case2 = helper(coins, amount, i+1,min);

        if(case1==-1) return case2;
        else if(case2==-1) return case1;
        else{
            return Math.min(case1,case2);
        }

    }
}
