"""
Time Complexity: 0(2 * len(nums))
Space Complexity: 0(3) -- constant, using 3 variables

Approach: Memorization -- saw repeated sub problems in exhaustive approach
"""
class Solution:
    def rob(self, nums: List[int]) -> int:

        # base-case
        if len(nums) == 1:
            return nums[0]
        
        # initialize rows
        rows = len(nums)

        # initialize variables
        case_0 = 0
        case_1 = nums[0]

        # fill the memorization2d
        for r in range(1,rows):
            
            # initialize temp variable for case_0
            temp_case_0 = case_0

            # not choose
            case_0 = max(temp_case_0, case_1)

            # choose
            if r == 1:
                case_1 = nums[r]
            else:
                # two steps back is max(memorization2d[r-2][0], memorization2d[r-2][1])
                # stored in 1-step-back case_0, which is now temp_case_0 variable
                case_1 = nums[r] +  temp_case_0
        
        # end of for loop

        return max(case_0, case_1)