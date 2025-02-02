# Time Complexity : O(n), n=len(nums)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        memo = {}
        def search(idx):
            if idx in memo:
                return memo[idx]
            # base case
            if idx >= len(nums):
                return 0
            # logic
            # choose to rob
            choose = nums[idx] + search(idx + 2)
            # don't rob
            _choose = search(idx + 1)
            memo[idx] = max(choose, _choose)

            return memo[idx]
        
        return search(0)    