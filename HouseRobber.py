"""
Problem2 (https://leetcode.com/problems/house-robber/)
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
         Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
         Total amount you can rob = 2 + 9 + 1 = 12.
Executed in leetcode: Yes
Time complexity: O(n)
Space complexity: O(1)
Comments: Initially, I tried a complicated logic with odd and even indices. Thereafter, used this simple method to do the same. 
I iterated over the array with the money in each house. Using two variables, the value at a house plus the non-adjacent value
is compared with current collection we have so far. The maximum is chosen. 
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        # Sanity check
        if not nums:
            return 0
        
        # Suppose there is only 1-2 house(s), we find the maximum
        elif len(nums)<=2:
            return max(nums)
        
        previous = 0
        current = 0
        
        for i in nums:
            temp = current
            current = max(previous + i, current)
            previous = temp
        return current
        
