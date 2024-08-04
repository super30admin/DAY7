class Solution:
    def helpingRobbers(self, nums, idx):
      
        if (idx >= len(nums)):
            return 0

        # case 1: choose to rob the house
        case_1 = nums[idx] + self.helpingRobbers(nums, idx + 2)

        # case 2: choose NOT to rob the house
        case_2 = 0 + self.helpingRobbers(nums, idx+1)

        return max(case_1, case_2)


    def rob(self, nums: List[int]) -> int:
        return self.helpingRobbers(nums, 0)