# 198. House Robber
#Attemp 1
class Solution:
    def rob(self, nums: List[int]) -> int:
        def maxMoney(ind, nums):
            if ind == 0:return nums[ind]
            elif ind<0:return 0

            if dp[ind] != -1: return dp[ind]
            
            take = nums[ind] + maxMoney(ind-2,nums)
            notTake = 0 + maxMoney(ind-1,nums)

            dp[ind] = max(take,notTake)
            return max(take,notTake)

        n = len(nums)
        dp = [-1 for _ in range(n)]
        return maxMoney(n-1, nums)
        