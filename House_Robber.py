# Approach:
# This problem can be solved using dynamic programming by maintaining a record of the maximum amount that can be robbed 
# up to each house without robbing two adjacent houses. We keep track of two values, `rob1` and `rob2`, representing
# the maximum amount that can be robbed up to the current house by either robbing it or skipping it. We iteratively
# update these values to get the maximum amount that can be robbed by the end of the array.

# Time Complexity : O(n), where n is the number of houses (length of nums)
# Space Complexity : O(1), as we only use two variables to keep track of the max amounts
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Initialize two variables to store the maximum amount robbable up to the previous two houses
        rob1, rob2 = 0, 0
        
        # Iterate over each house in nums
        for n in nums:
            # Calculate the maximum amount if robbing this house (rob2 + n) or skipping it (rob1)
            temp = max(rob1, rob2 + n)
            # Update rob2 to rob1 and rob1 to the new maximum
            rob2 = rob1
            rob1 = temp
        
        # rob1 now contains the maximum amount that can be robbed without alerting the police
        return rob1
