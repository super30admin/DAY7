
from typing import List

"""

    Student : Shahreen Shahjahan Psyche

    Brute-Force/Recursive:
        Time Complexity : O(2^n)
        Space Complexity : O(n)
    This solution faced time limit exceeded error in Leetcode

    Dynammic Programming:
        Time Complexity : O(n)
        Space Complexity : O(1)
    This solution passed all the test cases in Leetcode

"""

class Solution:
    
    # Recursive
    def _find_max(self, nums,  summed_val, curr_index):
            
            # Base case
            if curr_index > len(nums)-1:
                return summed_val
            
            # Case zero : current index value is nit taken
            case1 = self._find_max(nums, summed_val, curr_index+1)
            # Case one : current index value is taken
            case2 = self._find_max(nums, summed_val+nums[curr_index], curr_index+2)
            
            max_val = max(case1, case2)
            
            return max_val
            
        
    # DP
    def _find_max_dp(self, nums):
        
        max_val = 0
        prev_val = 0
        
        for i in range(len(nums)):
            # saving the calculated maximum value so that it does not get over written
            temp = max_val
            # saving new maximum value which is between case zero and case one/rob the house or stick with the maximum value
            max_val = max(prev_val+nums[i], max_val)
            # transferring the previous maximum value
            prev_val = temp
        
        return max_val
        
    # Driver method    
    def rob(self, nums: List[int]) -> int:
        
        curr_index = 0
        summed_val = 0
        
        # Recursive/brute force
        max_val = self._find_max(nums, curr_index, summed_val)
        # DP
        max_val = self._find_max_dp(nums)
        
        return max_val
        
        
        