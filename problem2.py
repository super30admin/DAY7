'''
## Problem2 (https://leetcode.com/problems/house-robber/)

Solution1: Exhaustive Recursion
TC: O(2^n)
SC: O(n) due to recursive stack
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no

Solution2: Dynamic programming with a 2-D matrix
TC: O(n) filling up the 2-D matrix since number of columns is 2 which is constant
SC: O(n) for the 2-D matrix since number of columns is 2 which is constant
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no

Solution2: Dynamic programming without a 2-D matrix using 2 variables
TC: O(n) running the loop to compute the final values
SC: O(1) since only 2 variables and a temporary variable is used
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
'''

#-----------------------Exhaustive Recursion-----------------------

class Solution1:
  def rob(self, nums):
    if not nums or len(nums) == 0:
      return 0

    return self.robHouseRecursion(nums, 0, 0)

  def robHouseRecursion(self, nums, idx, amount):
    #base cases
    if idx >= len(nums):
      return amount

    #logic
    case0 = self.robHouseRecursion(nums, idx + 1, amount)
    case1 = self.robHouseRecursion(nums, idx + 2, amount + nums[idx])

    return max(case0, case1)

#-----------------------Dynamic programming using matrix-----------------------

class Solution2:
  def rob(self, nums):
    if not nums or len(nums) == 0:
      return 0

    n = len(nums)
    matrix = [[0, 0].copy() for i in range(n + 1)]
    for idx in range(1, len(nums) + 1):
      matrix[idx][0] = max(matrix[idx - 1][0], matrix[idx - 1][1])
      matrix[idx][1] = matrix[idx - 1][0] + nums[idx - 1]
    
    return max(matrix[n])

#-----------------------Dynamic programming without matrix-----------------------

class Solution3:
  def rob(self, nums):
    if not nums or len(nums) == 0:
      return 0

    case0 = 0
    case1 = 0
    for idx in range(len(nums)):
      case0Temp = case0
      case0 = max(case0Temp, case1)
      case1 = case0Temp + nums[idx]

    return max(case0, case1)

nums1 = [1,2,3,1,4,5,7,2,1,5,3,8,4,2,4]
nums2 = [2,7,9,3,1,7,9,5,7,10,11,7,1,5,3,5,8,9,8]

print('Solution 1:')
s1 = Solution1()
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums1, s1.rob(nums1)))
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums2, s1.rob(nums2)))
print()

print('Solution 2:')
s2 = Solution2()
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums1, s2.rob(nums1)))
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums2, s2.rob(nums2)))
print()

print('Solution 3:')
s3 = Solution3()
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums1, s3.rob(nums1)))
print('Maximum amount that can be robbed from houses {} is {}.'.format(nums2, s3.rob(nums2)))
