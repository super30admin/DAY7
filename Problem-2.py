'''
    Time Complexity: O(n^2)
    Space Complexity: O(1)
    Approach: Using Dynamic Programming. 
    Return the max using choose and no choose case. 
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        # dp = [0 for i in range(n)]
        
        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2, n):
            temp = curr
            curr = max(curr, nums[i] + prev)
            prev = temp

        return curr