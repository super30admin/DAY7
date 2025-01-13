'''
Fill up a 2D matrix
'''
class Solution:
    
    def minCoinCount(self,coinList,amount):
        
        #1. Initialize a 2D matrix
        col = amount+1
        rows = len(coinList)+1
        
        matrix = [[None for j in range(col)] for i in range(rows)]
        
        #2. Fill-up 0th index columns with 0
        #   Fill-up 0th row "1 to (col-1)" indexed columns with 9999
        for i in range(0,rows):
            matrix[i][0] = 0
        
        for j in range(1,col):
            matrix[0][j] = 9999
        
        
        # 3. Fill-up all the columns of a matrix
        for i in range(1,rows):
            for j in range(1,col):
                
                #Case 1: amt >= coinList's coin
                if j >= coinList[i-1]:
                    # Go-to [i][j - coinList[i-1]] position, get the value and add +1 to it
                    # Go-to [i-1][j] position, get the value
                    # Set the minimum
                    matrix[i][j] = min(matrix[i][j - coinList[i-1]] + 1, matrix[i-1][j])
                
                #Case 2: amt < coinList's coint
                else:
                    # Go-to [i-1][j] position, get the value
                    matrix[i][j] = matrix[i-1][j]
                    
        for row in range(0,rows):
            print(matrix[row])
               
        print(matrix[rows-1][col-1])
        if matrix[rows-1][col-1] >= 9999:
            return -1
        else:
            return matrix[rows-1][col-1]
    
    def getSolution(self,coinList,amount):
        return self.minCoinCount(coinList,amount)

sol = Solution()
#sol.getSolution([1,2,5], 11)
sol.getSolution([1,5,7], 18)