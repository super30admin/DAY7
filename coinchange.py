
def coinChange(coins, amount) -> int:
    m = amount
    n = len(coins)

    matrix1 = [[999999 for i in range(m+1)] for j in range(n+1)]
    matrix1[0][0] = 0

    for i in range(1, n+1):
        for j in range(m+1):
            if j < coins[i-1]:
                matrix1[i][j] = matrix1[i-1][j]
            else:
                matrix1[i][j] = min(matrix1[i-1][j],1+matrix1[i][j-coins[i-1]])
    print(matrix1)

    if matrix1[n][m] == 999999:
        return -1
    return matrix1[n][m]
  
    
coins = [1,2,5,10]
amount = 18


print(coinChange(coins, amount))

