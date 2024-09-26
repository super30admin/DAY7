"""
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
is that adjacent houses have security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums == None:
            return 0
        
        n = len(nums)
        skip = 0
        take = nums[0]

        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]

        return max(skip, take)


        """
        maxNum = max(nums)
        print(maxNum)
        
        
        
        if nums = 0:
            return -1

        numsMax = 0

        for i in range(0,len(nums)):
            if(nums[i] > max)
                max = nums[i]
                rem = 
                if(nums[i-2] or nums[i+2])

        if(nums[i-1] or nums[i])

        """


nums = [1,2,9,3,5]
result = max(nums)
print(result)