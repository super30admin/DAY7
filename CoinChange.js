/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */

// Approach: I will use the dynamic programming approach using array
// Time Complexity is O(n*m) where n is the length of the coins array and m is the amount
// Space Complexity is O(n*m), 2D array of size n*m
var coinChange = function(coins, amount) {
    var rows   = coins.length +1;
    var column = amount+1;
    var table  = [];
    table[0]   = [];
    var max    = 999999;
    table[0][0] = 0;
    for(let i = 1; i < column; i++){
        table[0][i] = max;
    }
    for (let i = 1; i < rows; i++) {
        table[i] = [0]; // Empty arrays for the other rows
    }
    for(let i = 1; i< rows; i++){
        for(let j = 1; j< column; j++){
            if(j  < coins[i-1]){
                table[i][j] = table[i-1][j];
            }else{
                table[i][j] = Math.min(table[i-1][j], 1 + table[i][j-coins[i-1]]);
            }
        }
    }
    return table[rows-1][column-1] == max ? -1 : table[rows-1][column-1];

};