# 322. Coin Change_Solution_Q1

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return 0
        
        n= len(coins)
        
        # amount is 11 , n: len(coins)
        dp= [[0] * (amount + 1)] * (n +1)
        for i in range(1, amount +1):
            dp[0][i] = amount +1 # infinity

        for i in range(1, n+1): # iterating on rows i=0,1,2,3
            for j in range(1, amount+1):
                # till the time denomination > amount(j) -> 0 case
                if  j < coins[i-1]:
                    # 0 case
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= min(dp[i-1][j], 1+dp[i][j- coins[i-1]])
        # put a check as amount is infinity
        if dp[n][amount]== amount+1:
            return -1
        return dp[n][amount] 

# TC: O(m*n) m-> coins n-> amount+1
#SC: O(m*n) 

-------------------------------------------------------------------------------------------------------

# 198. House Robber_Solution_Q2

# recursion

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums== None or len(nums)==0:
            return 0
        return self.recurse(nums, 0, 0)

    def recurse(self, nums: List[int], index: int, amountRobbed: int) -> int:

        # base case
        if index >= len(nums):
            return amountRobbed

        #logic
        case0 = self.recurse(nums, index+1, amountRobbed)

        case1= self.recurse(nums, index +2, amountRobbed + nums[index])

        return max(case0, case1)       

# TC: O(2^n) length of list n , 2 choices
# SC: O(n)

# Alternative1

# dp

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums== None or len(nums)==0:
            return 0
        n = len(nums)

        dp= [[0 for i in range(2)] for j in range(n)]
        dp[0][1] = nums[0]
        for i in range(1,n):
            dp[i][0]= max(dp[i-1][0], dp[i-1][1])
            dp[i][1]= nums[i]+ dp[i-1][0]

        return max(dp[n-1][0], dp[n-1][1])

# TC: O(n) 
# SC: O(n)

# Alternative2

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums== None or len(nums)==0:
            return 0
        n = len(nums)
        skip =0
        take= nums[0]
        for i in range(1,n):
            temp=skip
            skip=max(skip, take)
            take= nums[i]+ temp
        
        return max(skip, take)
    
# TC: O(n) 
# SC: O(1)