#Space complexity : O(numbers of coin * amount)
#Time Complecity: O(numbers of coin * amount)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows= len(coins) + 1
        columns = amount + 1
        # arr= list(list())
        arr= [[amount + 1 for _ in range(columns)] for _ in range(rows)]
        for r in range(rows):
            arr[r][0] = 0        
        for r in range(1,rows):
            for c in range(1,columns):
                if( c < coins[r-1]):
                    arr[r][c]= arr[r-1][c] 
                else:
                    arr[r][c]= min(arr[r-1][c], 1+ arr[r][c - int(coins[r-1])])
        if(arr[rows-1][columns-1] != amount+1):
            return arr[rows-1][columns-1]
        return -1
