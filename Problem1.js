//Coin Change (LC 322)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes initially I had problems with using a object instead of a map

//Use recursion and memoization I am calculating the minimum number of coins that I need to make change
/**
 * @param {number[]} coins
 * @param {number} amount;
 * @return {number}
 */
var coinChange = function(coins, amount) {
    if(coins.length === 0 || coins === null ){
        return -1;
    }
    if(amount === 0){
        return 0;
    }
    let memo = {};
    function recurse(sum){
        if(memo[sum] !== undefined){
            return memo[sum];
        }
        if(sum < 0){
            return -1;
        }
        if(sum === 0){
            return 0;
        }
        let min = Infinity;
        for(let i=0;i<coins.length;i++){
            let testMin = recurse(sum - coins[i]);
            if(testMin >= 0){
                min = Math.min(min, testMin);
            }
        }
        memo[sum] = min + 1;
        return memo[sum];
    }
    
    recurse(amount);
    return memo[amount] === Infinity ? -1 : memo[amount];
};