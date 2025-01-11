class Solution:
    # ------------------Recursion (output will be time limit exceeded)
    # def rob(self, nums: List[int]) -> int:
    #     if len(nums) == 0:
    #         return 0

    #     return self.recurse(nums, index = 0, amountRobbed = 0)
    
    # def recurse(self, nums: List[int], index : int, amountRobbed: int) -> int:
    #     # base case
    #     if index >= len(nums):
    #         return amountRobbed

    #     # logic 
    #     case0 = self.recurse(nums, index + 1, amountRobbed) # if we choose not to rob the house 
    #     case1 = self.recurse(nums, index + 2, amountRobbed + nums[index]) # if we choose to rob house at 'index'

    #     return max(case0, case1)

    #----------------------------------Using DP Time O(n) Space O(n)--------------------
    # def rob(self, nums: List[int]) -> int:
    #     n = len(nums)
    #     dp = [[0,0] for _ in range(n)] # Mind this initialization *******Most IMP************
    #     dp[0][1] = nums[0]
    #     for i in range(1, n):
    #         dp[i][0] = max(dp[i-1][0], dp[i-1][1])
    #         dp[i][1] = dp[i-1][0] + nums[i]
        
    #     return max(dp[n-1][0], dp[n-1][1])

    #--------------------------------We can still optimize the space we just need two variable variable and one temp variable
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        skip = 0
        take = nums[0]
        for i in range(1, n):
            temp = skip
            skip = max(skip, take)
            take = nums[i] + temp

        return max(skip, take)
        
        return max(dp[n-1][0], dp[n-1][1])