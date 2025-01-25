# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

amounts = [float('inf')] * (amount + 1)
amounts[0] = 0

for amt in range(1, amount+1):
    for coin in coins:
        if coin <= amt:
            amounts[amt] = min(amounts[amt], 1 + amounts[amt-coin])
    
return amounts[-1] if amounts[-1] != float('inf') else -1