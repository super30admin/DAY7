// time complexity: O(m*n)
// space complexity: O(n)
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    let n = amount;

    // Initialize dp array with Infinity values
    let dp = Array(n + 1).fill(Infinity);
    
    dp[0] = 0; // Base case: 0 amount requires 0 coins
    

    // Fill the dp table
    for (let coin of coins) {
        for (let j = coin; j <= n; j++) {
            dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
        }
    }

    return dp[n] === Infinity ? -1 : dp[n];
    
};