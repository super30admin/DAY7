# Time Complexity : O(n), where n is the number of houses
# Space Complexity : O(1), because we are just using 3 extra variables
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we can use a 2d array to solve this problem, where we store the max amount of previous houses's skip or rob, but this will have SC - O(n)
# here, we are just 2 variables, because for every house we just look at previous house's amount for both cases
# if we skip the current house, then the amount is max of previous house cases
# if we rob the current house, then we skipped the previous house and we will add current house's amount


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None:
            return 0

        # exhaustive apparoch because we need to consider all ways to rob the houses to max amount
        # two ways for each house - either skip or rob
        # skip initialized with 0, because initially no house robbed, then amount is 0
        skip = 0
        # rob initialized with the first house's amount
        rob = nums[0]

        # now we will traverse the list, and check for the max amount in each house's both cases
        for i in range(1, len(nums)):
            # storing the value of current skip to add to robbed case
            prevSkip = skip
            
            # if we are skipping this house, then the amount we take is maxmium amount 
            # from the 2 cases of the previous house
            skip = max(skip, rob)

            # if we decide to rob this house, then it means we did not rob the previous house
            # so if we rob this house, amount will be previous skip + current house's amount
            rob = prevSkip + nums[i]

        return max(skip, rob)
        