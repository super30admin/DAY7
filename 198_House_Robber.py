# Time: O(n)
# Space: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if ( len(nums) == 0):
            return 0 
        skip=0
        take=0
        for r in range(1,len(nums)+1):
            tempskip = skip
            skip = max(skip, take)
            take= tempskip + nums[r-1]
        return(max(skip,take))
