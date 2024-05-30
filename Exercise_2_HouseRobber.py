# Time Complexity :

# O(N) , N = no. of elements in nums


# Space Complexity :  

# O(1) , We are just using two variables to update the maxamount robbed at each house inthe nums.


# Approach:
# We approach the problem using either "selecting" or "not selecting" each house for robbing corr. amount.
# Create two variables that store the "skip" and "take" values that corr. to "Not picking" and "picking"
# the house for robbing.
# ===> Then for each house, update: skip = min(previous skip, previous take)
# ===>                            : take = previous skip + current nums[i] value
# We finally return the max("skip" and "take"), since that would correspond to the maximum amount robbed
# given the constraints.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)==0:
            return 0

        rows = len(nums)

        skip = 0         # For not selecting the house
        take = nums[0]   # for selecting the house

        for i in range(1, len(nums)):
            tempSkip = skip
            #update skip
            skip = max(skip, take)    # max of prev(above row's skip and take values)
            take = tempSkip + nums[i]  # sum of previous "skip" and current num value 

        return max(skip, take)