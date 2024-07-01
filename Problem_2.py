"""
Problem2 (https://leetcode.com/problems/house-robber/)
"""


# Approach: 1

class Solution:
    def helpingRobbers(self, nums, idx):
        #BASE
        if (idx >= len(nums)):
            return 0
        
        #LOGIC
        # case 1: choose to rob the house
        case_1 = nums[idx] + self.helpingRobbers(nums, idx + 2)
        
        # case 2: choose NOT to rob the house
        case_2 = 0 + self.helpingRobbers(nums, idx+1)
        
        return max(case_1, case_2)
    
    
    def rob(self, nums: List[int]) -> int:
        return self.helpingRobbers(nums, 0)
        
        
        
# Approach 2: DP matrix TC= O(N) SC=O(N)

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
       
        
        houseMatrix = [0 for _ in range(n )]
        
        houseMatrix[0] = nums[0]
        houseMatrix[1] = max(nums[0], nums[1])
        
        for i in range(2, n):
            houseMatrix[i] = max(houseMatrix[i - 1], houseMatrix[i - 2] + nums[i])
            
        return houseMatrix[n - 1]
        