// Time Complexity : (O)2n^m . n = number of coins. m = amount
// Space Complexity : (O)2n^m
// Did this code successfully run on Leetcode : timelimit exceeded


//Recursive solution
//Make two decision and get a number of coins needed to make the given amount
//choose a coin or not choose a coins
//then compare the min of two result and return the minimum

class Solution {
    func coinChange(_ coins: [Int], _ amount: Int) -> Int {
        //edge
        if coins.count == 0 {
            return 0
        }
        return helper(coins,amount,0,0)
    }
    
    func helper(_ coins: [Int],_ amount: Int, _ index: Int,_ min: Int) -> Int {
        //base
        if amount == 0 {
            return min
        }
        
        if amount < 0 || index == coins.count {
            return -1
        }
        //logic
        //choose a coin
        let case1: Int = helper(coins, amount - coins[index], index, min+1)
        // don't choose a coin
        let case2: Int = helper(coins, amount, index+1, min)
        
        if case1 == -1 {
            return case2
        }
        if case2 == -1 {
            return case1
        }
        
        Swift.min(case1,case2)
    }
}


//DP tabular solution
//Create a matrix to find all minimum number of coins to make a given amount from zero
//Create 2d array with first row infinity and first column zero
//set minimum number of coins needed to make the amount. There are two cases. case 1 is not to select a coin and case 2 is select a coin. For not select a coin get the previous(row) minimum value. For select a coin find the previously calculated minimum of coin to make a amount less than the current row amount.
//Don't need to slect a coin if coin is greater than row amount
//get min of zero case and selected case value

class Solution {
    func coinChange(_ coins: [Int], _ amount: Int) -> Int {
        //edge
        if coins.count == 0 {
            return 0
        }
        var dp = [[Int]](repeating: [Int](repeating: 0, count: amount+1), count: coins.count+1)

        //fill infinity for first row
        for index in 1..<dp[0].count {
            dp[0][index] = 9999
        }
        //fill zero for first dummy column
        for index in 0..<dp.count  {
            dp[index][0] = 0
        }
        for i in 1..<dp.count { // amount
            for j in 1..<dp[0].count { // coin
                if j < coins[i - 1] {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = Swift.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1) //min of zero case and selected case value
                }
            }
        }
        let result = dp[coins.count][amount]
        return result >= 9999 ? -1 : result
    }
    
}

