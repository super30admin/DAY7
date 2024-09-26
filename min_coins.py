def min_coins(coins, amount):
    
    rows = len(coins) + 1
    cols = amount + 1
    min_coins = [[None for i in range(cols)] for j in range(rows)]
    
    for i in range(rows):
        min_coins[i][0] = 0
        
    for j in range(1, cols):
        min_coins[0][j] = float("inf")
        
        
    for coin in range(1, rows):
        
        for amt in range(1, cols):
            
            if coins[coin - 1] > amt: # we do i-1 as we have added an extra row to matrix for 0 value, just take it from above row
                # Example coin is 5 until amt is 5 we cant do anything so just take from above
                
                min_coins[coin][amt] = min_coins[coin - 1][amt]
                
            else:
                # we compare upper and left and check min
                # we go back on the same row, coin value times. For example in whiteboard we did 5 steps back for coin 5 which is coins[coin - 1] and add 1
                upper = min_coins[coin - 1][amt] 
                left = min_coins[coin][amt - coins[coin - 1]] + 1
                min_coins[coin][amt] = min(upper, left)
                
    if (min_coins[rows-1][amount]) == float("inf"):
        return -1
    else:
        return min_coins[rows-1][amount]
