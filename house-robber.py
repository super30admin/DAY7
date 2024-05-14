#time complexity: O(n)- traversing the array once
#space complexity: O(1) - only skip and take used-constant time
# approach: initialise skip with 0-not choose
#take with nums[0]
# update skip with max value of previous skip and take
# update take with previous skip + value of present house
# return the maximum of last skip and take


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        skip = 0
        take = nums[0]
        for i in range(1,n):
            temp = skip
            skip = max(skip,take)
            take = temp+nums[i]
        return max(skip,take)