"""
Time complexity: O(NK)
Space complexity: O(N^2)
"""
class Solution:
    def coinChange(self, coins, amount):
        m = amount + 1
        n = len(coins) + 1
        rows, cols = (n, m) 
        # Initialize a 2D array of size number of coin denomination + 1 and amount + 1
        dp = [[0 for i in range(cols)] for j in range(rows)]
        
        # Initialize the top row to the value of infinity so that our DP formula works for the first denomination row
        for i in range(1, m):
            dp[0][i] = float('inf')
        
        for i in range(1, n):
            for j in range(1, m):
                # Copy the previously computed element for the same amount from above,
                # until the amount reaches the value of denomination of coin
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                # Go take min  of (#denomination steps back and then add 1) and the previously computed top value for the same amount      
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)
        result =  dp[n-1][m-1]
        # When we can find no combination that adds to the target amount, last row last col value stays inf and we return -1
        if result == float('inf'):
            return -1
        else:
            return result


def main():
    coins = [1, 2, 5]
    amount = 11
    solution = Solution()
    print(solution.coinChange(coins, amount))

if __name__ == "__main__":
    main()