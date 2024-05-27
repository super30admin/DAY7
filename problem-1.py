# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# space complexity : O(m*n), where m is the number of rows and n is the number of columns

# Approach :

# with the target and the value of each compute and store cases when one coin is not used and the other is used in a 2d matrix
# for base case 0 except for amount 0 keep amount+1 as the value for other amounts cannot be made with zero value coin
# if value of coin is greater than the amount, use the amount present at the [i-1][j] th index
# if value of coin less or equal to amount calculate the minimum no of coins by comparing value [i-1][j] th index and 1+ [i][j-coins[i-1]] th index
# incase the coins could not make the amount, the last element in the 2d array would be (amount+1), return -1 in this case


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        if not coins:
            return -1

        noColumns = amount+1
        noRows = len(coins)+1

        arrCoins = [[0 for j in range(noColumns)] for i in range(noRows)]

        for j in range(1, noColumns):
            arrCoins[0][j] = amount+1

        for i in range(1, noRows):
            for j in range(1, noColumns):
                if j < coins[i-1]:
                    arrCoins[i][j] = arrCoins[i-1][j]
                else:
                    arrCoins[i][j] = min(
                        arrCoins[i-1][j], 1+arrCoins[i][j-coins[i-1]])

        if arrCoins[noRows-1][noColumns-1] == amount+1:
            return -1

        return arrCoins[noRows-1][noColumns-1]
