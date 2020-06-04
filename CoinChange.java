/*
Brute force recursive solution for

we will looking into every possible combination of the coin change
subset and we will choose the subset having minimum number
we will have two choice for every coin either we will choose it or we will leave it
and we will build recursive tree using this approach

Time Complexity : k * (2^n)
K =  no choice of  coins
n = amount 

Space complexity : recursive space will be used O(N) n is the depth of recursion
is Worked on leetcode : No Time Limit Exceded
*/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 ) return 0;
        
        return get_min_coin(coins, amount, 0, 0);
        
    }
    public int get_min_coin(int[] coins, int amount, int index, int min_coin){
        
//      edge case
        if(amount ==  0 )      return min_coin;
        
        if(amount < 0 || index == coins.length)      return  -1;
        
//         logic
//         you choose the coin
        int case1 =  get_min_coin(coins, amount - coins[index], index,  min_coin + 1);
        
//         you dont choose the coin
        
        int case2 = get_min_coin(coins, amount, index + 1, min_coin);
        
        if (case1 == -1 ) return case2;
        if (case2 == -1 ) return case1;
        return Math.min(case1,case2);
    
    }
}