"""
DP-1

Problem2 (https://leetcode.com/problems/house-robber/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12. 

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400

Time Complexity : O(n) where n is no of houses
Space Complexity : O(1) because we're using variables to store robbed, not robbed which is constant
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Since we're facing repetitive subproblems, we need to go with dp approach that will have rows as nums i.e., house and columns as 0 or 1 which indicates whether it is robbed or not robbed.
But we're only using the previous 1 house results so we don't need all the previous houses results so we're going to use 2 variables i.e., robbed and not_robbed instead of 2d array to keep track 
of max robbed & not robbed values at previous houses and also we use a temporary var to store the current robbed value before updating it to robbed value since we need to calculate the not robbed
with the temporary var. At the end we fetch max of robbed and not_robbed and return it.
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1

        robbed = nums[0]
        not_robbed = 0

        for i in range(1, len(nums)):
            curr_robbed = nums[i] + not_robbed
            not_robbed = max(robbed, not_robbed)
            robbed = curr_robbed

        return max(robbed, not_robbed)

        
        