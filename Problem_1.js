// Time Complexity : O(m^2 * n)
// Space Complexity : O(m^2)
// Did this code successfully run on Leetcode : Most cases passed, but test case of ([1], 10000) gave runtime error. 
// Any problem you faced while coding this : It was difficult to understand at first, so did the problem for smaller inputs and then arrived at the below solution


// Your code here along with comments explaining your approach
// Approached the problem with what was taught in class but with recurisve approach to understand the brute force technique and then memoized it to reduce run time. 

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {

    var coinHelper = (coins, amount, memo = new Map()) => {
        if(amount in memo) return memo[amount];
        if(amount === 0) return [];
        if(amount < 0) return null;
        let bestCoins = null;
        for(let i=0; i<coins.length; i++){
            let targetAmt = amount - coins[i];
            let returnCoins = coinHelper(coins, targetAmt, memo);
            if(returnCoins != null){
                let newCoins = [...returnCoins, coins[i]];
                if(bestCoins === null || newCoins.length < bestCoins.length){
                    bestCoins = newCoins;
                }
            }
        }
            memo[amount] = bestCoins;
        return bestCoins;
    }

    var res = coinHelper(coins, amount);

    return res != null ? res.length : -1;
};