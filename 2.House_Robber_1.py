"""
Time Complexity: 0(2 * len(nums))
Space Complexity: 0(2 * len(nums))

Approach: Memorization -- saw repeated sub problems in exhaustive approach
"""
class Solution:
    def rob(self, nums: List[int]) -> int:

        # base-case
        if len(nums) == 1:
            return nums[0]

        rows = len(nums)
        cols = 2

        memorization2d = [[0 for c in range(0,cols)] for r in range(0,rows)]

        # set the 0-th row value
        memorization2d[0][0] = 0 # not-choose
        memorization2d[0][1] = nums[0] # choose

        # fill the memorization2d
        for r in range(1,rows):
            
            # not choose
            memorization2d[r][0] = max(memorization2d[r-1][0], memorization2d[r-1][1])

            # choose
            if r == 1:
                memorization2d[r][1] = nums[r]
            else:
                memorization2d[r][1] = nums[r] + max(memorization2d[r-2][0], memorization2d[r-2][1]) 
        
        # end of for loop

        return max(memorization2d[-1][0], memorization2d[-1][1])