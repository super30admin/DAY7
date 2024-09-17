# APPROACH 1: (MY APPROACH - BEFORE CLASS) 
# Time Complexity : O(n^2), n is the length of nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Intially considered to take sum of alternate elements but needn't be the gap between two houses be 1.
#
#
# Your code here along with comments explaining your approach
# 1. Do this for each value of gap from 0 to len(nums)
# 2. Take 2 sum starting from 0 and 1 index alternatively. Increement the index by current gap value.
# 3. Store the max value obtained in each iteration and increement the gap by 1 at the end of iteration

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        gap = 1
        
        while gap < len(nums) - 1:
            ind_1, ind_0, sum_1, sum_0 = 1, 0, 0, 0
            while ind_1 < len(nums) and ind_0 < len(nums):
                sum_1 += nums[ind_1]
                sum_0 += nums[ind_0]
                ind_1, ind_0 = ind_1 + gap, ind_0 + gap
                
            max_sum = max(sum_1, sum_0)
            gap += 1
                
        return max_sum
        
        

# APPROACH 2: BRUTE FORCE (RECURSION) 
# Time Complexity : O(2^n), n:length of nums
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : NO (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None 
#
#
# Your code here along with comments explaining your approach
# 1. Recursive solution, arguments: nums, amount (current), ind in nums (current)
# 2. Base case: if ind >= len(nums) -> return the amount
# 3. 2 cases: Don't choose the house -> recursively call function with nums, amount, ind inc by 1 (can rob the next house)
#             Choose the house -> recursively call function with nums, amount + current house value + ind inc by 2 (as we can't rob the adjacent house)
# 4. return the maximum of above 2 cases


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        return self.helper(nums, 0, 0)
    
    def helper(self, nums, amount, house_ind):
        
        if house_ind >= len(nums):
            return amount
        
        # Don't choose the house
        case_1 = self.helper(nums, amount, house_ind + 1)
        
        # Choose the house
        case_2 = self.helper(nums, amount + nums[house_ind], house_ind + 2)
        
        return max(case_1, case_2)




# APPROACH 3: DYNAMIC PROGRAMMING
# Time Complexity : O(n), n: length of nums as matrix has only 2 columns - constant
# Space Complexity : O(n), size of dp is 2*n
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Create a 2d matrix of n rows and 2 columns (Yes or No). Each cell stores the maximum amount the roober can get by robbing / not robbing the house
# 2. For house not robbed (0 column) -> cell: max(previous row)
# 3. For house robbed -> cell : house value + No case of previous row
# 4. Result: max of the last row of dp


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 0:
            return 0
        
        dp = [[None for _ in range(2)] for _ in range(len(nums))]
        
        dp[0][0] = 0
        dp[0][1] = nums[0]
        
        for row in range(1, len(dp)):
            dp[row][0] = max(dp[row - 1][0], dp[row - 1][1])
            dp[row][1] = nums[row] + dp[row - 1][0]
                
        return max(dp[-1][0], dp[-1][1])
                
