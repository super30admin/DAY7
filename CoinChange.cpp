//given is the array [1,2,5] total amount = 11
// now the first approach is the getting the maximum number out of the array
// so if we take 5,5,1, that will be the fastest way to reach the total amount 
// but that can not be true for all the cases
// [2,2,5] -> in this case if we take 5,5, the last remaining would be 2 which is not feasible
// [5,2,2,2]-> 11

//this approach is called greedy

// now the next possible solution is you have to find all the combinations
// as we know findng the all possible solutions require the time complexity of 2^n it is an
// exponantial time complexity

// here we are solving this problem as part of smaller sub problem
// 1. finding the sum
// 2. with the combination of different coins

// if we consider the coins range [1...N]
// if we start with first coin we have two choices
// select 1:
// range of coin is same but amount will be reduced by the amount of 1st coin
// dont select 1:
// we have the same amount but the range of coin is different [2..N]

// so we can say 

// if we have amount 11 and number of coins 3 - [1,2,5]
// we can find the combination for each amount 0,1,2,3,4,5,6,7,8,9,10,11
// so let us start with 0
// dp[0] =0
// logic
// for each coin
// if (coin <= curr_amount)
// dp[1] = (1+dp[0])
// try coin 1
// dp[2] = (1+dp[1] = (2)
// try coin2 
// dp[2] = (1+dp[0]) = 1
// min(dp[21],dp[22]) == dp 2
// for each coin
// if coin <= amount 
// min(dp[curr_amount], 1+dp[curr_amount -coin])

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // we have the combination of coin and amount
        // we can store the sum of the each amount from 0..amount,
        // so we can use the previous some to get the amount
        //[0....N]
        vector<int> dp(amount+1,amount+1);
        
        // to get the amount 0 we need 0 coins
        dp[0] = 0;

        // now starting from the amount 2
        for(int i = 1; i <=amount;i++)
        {
            for(int coin : coins)
            {
                if(coin <= i)
                    dp[i] = min(dp[i],1+ dp[i-coin]);
            }
        }
        if(dp[amount] == amount +1)
            return -1;
        return dp[amount];
    }
};