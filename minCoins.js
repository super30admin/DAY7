/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    //edge case 
    if(!coins) return 0;
    var dp = new Array(coins.length+1);
    var m = dp.length;
    
    for(i=0;i<m;i++){
        dp[i] = i;
        dp[i] = new Array(amount+1);
        dp[i][0] = 0;
    }
    
    var n = dp[0].length;
    for(i = 1; i<n;i++){
        //To avoid integer overflow, assign 99999
        dp[0][i] = 99999;
        
    }
    
    for(i = 1; i<m; i++){
        for ( j = 1; j < n ; j++){
            //i-1 since we used dummy row with 0 //coins[i-1] is denomination of the coin
            if(j < coins[i-1]){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = Math.min(dp[i-1][j], (1+ dp[i][j-coins[i-1]]));          
            }
        }
    }
    
    var result = dp[m-1][n-1];
    if(result >= 99999) return -1;
    return result;
    
        
    
};

//Time Complexity : no_of_coins x amount

//space complexity : no_coins x amount