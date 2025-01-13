"""
Time Complexity: 0(amount * denomination-count)
Space Complexity: 0(amount * denomination-count)
Approach: 2D Memorization / Tabularization
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        # initialize rows and columns
        rows = len(coins)+1
        columns = amount + 1

        # initialize a 2D matrix
        memorization2D = [[0 for c in range(columns)] for r in range(rows)]

        # set the row 0th from col index 1 to col index amount + 1 to infinity
        for c in range(1,columns):
            memorization2D[0][c] = float('inf')

        # perform 2D memorization

        for r in range(1,rows):

            # get the denomination
            denomination = coins[r-1]

            for c in range(1,columns):

                # copy the value from above if (c) i.e. current amt < denomination
                if c < denomination:
                    # copy from above
                    memorization2D[r][c] = memorization2D[r-1][c]
                
                else:
                    # get value from above -- not choose
                    # get value denomination step back in the same row, add +1 to it -- choose
                    # store the minimum value
                    above = memorization2D[r-1][c]
                    denomination_steps = memorization2D[r][c-denomination] + 1

                    memorization2D[r][c] = min(above, denomination_steps)
            
            # end of columns 
        # end of rows

        # return the result

        # for r in range(0,rows):
        #     print(memorization2D[r])

        if memorization2D[-1][-1] == float('inf'):
            return -1

        return memorization2D[-1][-1]