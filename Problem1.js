//Time: O(m*n), Space: O(m*n) 
//where m is the length of coins array and n is the amount
// Leetcode soution running and accepted
 var coinChange = function(coins, amount) {
    if(coins.length ==0) return -1;
    let m = coins.length;
    let n = amount
    let dp = Array(m+1).fill().map(() => Array(n+1).fill(0));;
        
    for(let i=1;i<n+1;i++){
        dp[0][i] = amount + 1;
    }
    for(let i=1;i<m+1;i++){
        for(let j=1;j<n+1;j++){
           if(j < coins[i-1]){
               dp[i][j] = dp[i-1][j]
           }else{
               dp[i][j]= Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
           }
        }
    }
    if(dp[m][n] == amount+1) return -1;
    return dp[m][n];
};