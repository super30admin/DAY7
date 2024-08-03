# Time complexity - O(n)
# Space complexity - O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [i for i in nums]
        for i in range(1, len(nums)):
            if i == 1:
                dp[i] = max(dp[i], dp[i-1])
            else:
                dp[i] = max(dp[i-1], dp[i-2]+dp[i]) # alternate pick and hence 
        return max(dp)
        
        
# REcursive solution 
# TIme complexity- O(2^n) where n is the number of houses
# space complexity = O(n)
class Solution2:
    def rob(self, nums: List[int]) -> int:
        def helper(nums, index):
            if index >= len(nums):  # dont take len(nums) - 1
                return 0

            # dont choose
            case1 = helper(nums, index+1)
            case2 = nums[index] + helper(nums, index+2)
            return max(case1, case2)
        return helper(nums, 0)


    
