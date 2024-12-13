class Solution:
    def rob(self, nums):
        def maxBounty(n, b = {}):
            if n == 0: return nums[0]
            if n == 1: return max(nums[0], nums[1])
            if n == 2: return max(nums[0]+nums[2], nums[1])
            if n in b: return b[n]
            b[n] = max(maxBounty(n-1), maxBounty(n-2)+ nums[n])

            return b[n]

        return maxBounty(len(nums)-1)