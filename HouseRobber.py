'''
Recursion solution:

class Solution:
    def recurse(self, nums,i, amount):
            #base case
            if i>=len(nums):
                return amount
            #calls
            return max(self.recurse(nums, i+1, amount),self.recurse(nums, i+2, amount+nums[i]))
        
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        return self.recurse(nums,0,0)

With dp array solution:

class Solution:
           
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = [[0 for _ in range(2)] for _ in range(len(nums)+1)]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[len(nums)-1][0],dp[len(nums)-1][1])
'''
class Solution:
           
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        skip = 0
        take = nums[0]
        for i in range(1,len(nums)):
            tempSkip = skip
            skip = max(skip,take)
            take = tempSkip + nums[i]
        return max(skip,take)