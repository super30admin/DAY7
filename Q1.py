######### Coin Change

# Time Complexity : O(n*m) where n is the target amount and m is the number of coins
# Space Complexity : O(n*m) where n is the target amount and m is the number of coins
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially had difficulty understanding how to approach the question and messed up the index computation.

# go through the array and keep filling it such that if the amount-current_coin_value is valid then we take the min between the amount - current_coin and the previous coins value to reach target.


def coin_change(coins,target):
    if not coins:
        return -1
    
    dp = [[target + 1] * (target + 1) for _ in range(len(coins) + 1)]
    dp[0][0] = 0

    for i in range(1,len(dp)):
        for j in range(len(dp[0])):
            dp[i][j] = dp[i - 1][j]
            if j - coins[i-1] >=0:
                dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])

    if dp[-1][-1]!= target +1:
        return dp[-1][-1]
    else:
        return -1

# Time Complexity : O(n) where n is the target amount
# Space Complexity : O(n) where n is the target amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# can further optimise by overwriting as we only need the previous row value and current row
def coin_change_2(coins,target):
    if not coins:
        return -1
            
    dp = [target + 1] * (target + 1) 
    dp[0]= 0
        
    for i in range(1,len(dp)):
        for j in range(len(coins)):
            dp[i] = dp[i]
            if i - coins[j] >= 0:
                dp[i] = min(dp[i],1+dp[i-coins[j]])
        
    if dp[-1]!= target +1:
        return dp[-1]
    else:
        return -1
