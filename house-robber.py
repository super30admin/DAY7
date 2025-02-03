'''
Time complexity: O(n) where n is the number of houses
Space complexity:  O(n) where n is the number of houses
Did this code successfully run on Leetcode :  Yes (#198)
Any problem you faced while coding this : No
Approach:
- Create a dp array of size n where n is the number of houses
- Initialize dp[0] = nums[0] and dp[1] = max(nums[0],nums[1]) as we can rob either the first house or the second house
- For each house, we have two options:
    - Rob the house: dp[i] = dp[i-2] + nums[i]
    - Skip the house: dp[i] = dp[i-1]
'''

from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
            if len(nums) <= 2:
                try:
                    return max(nums[0],nums[1])
                except IndexError:
                    return nums[0]

            dp = [0 for _ in range(len(nums))]

            dp[0] = nums[0]
            dp[1] = max(nums[0],nums[1])

            for hIdx in range(2,len(nums)):
                dp[hIdx] = max(dp[hIdx-2]+nums[hIdx],dp[hIdx-1])
            
            return dp[len(nums)-1]

#Driver code
s = Solution()
nums = [2,7,9,3,1]
print(s.rob(nums)) #12