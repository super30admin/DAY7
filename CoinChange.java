/**

Greedy Aproach does not work - 

Recursively check for all permutations and check for min coins matching amount.

Time complexity  -> 2^(n+m) where n: no. of elements, m: target value, 
Space complexity -> O(m)

But time limit exceeded. Hence apply Dp to use repeated ans. 
DP Approcah- Tabulation get decision parameters and build the matrix . For each value check min of the pev col or the remaining sum calculated.

TC- O(m*n), SC = O(m*n)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
    //    int count = -1;
    //     count = helper(coins, amount, 0, 0);
    //     return count;


    // DP approach


    int m = coins.length;
    int n = amount;
    int[][] mat = new int[m+1][n+1];

    for(int i = 1 ;i<=n ;i ++){
        mat[0][i] = 999999;
    }
    // j denotes the amounts -> 0,1,2... amount

    for(int i = 1;i <=m ;i++){
        for(int j = 1; j<=n; j++){
            // the j... have 0 as well. and hence we start from 1
            if(j<coins[i-1]){
                // we do not have availability of choosing
                mat[i][j] = mat[i-1][j];
            } else {
                mat[i][j] = Math.min(mat[i-1][j], 1+ mat[i][j-coins[i-1]]);
            }
        }
    }
    if(mat[m][n] >= 999999 ) return -1;
    return mat[m][n];
    }

    // recursive TLE
    private int helper (int[] coins, int amount, int i, int count ){
        //base
        if(amount == 0){
            return count;
        }
        if(amount < 0 || i>= coins.length){
            return -1;
        }
        //logic

        //take
        int take = helper(coins, amount-coins[i], i, count+1);
        //not take
        int nottake = helper(coins, amount, i+1, count);


        if(take == -1) return nottake;
        if(nottake == -1) return take;
        
        return Math.min(take, nottake);
    }
}