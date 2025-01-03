/**
 * SC : O(1)
 * TC : O(N^2)
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
  var ar= new Array(amount+1).fill(Infinity);
    ar[0]=0;
    for(let c of coins){
     for(let i=c;i<=amount;i++){
        ar[i] = Math.min(ar[i],ar[i-c]+1);
     }
    }
    return ar[amount]==Infinity ? -1 : ar[amount];  
};
