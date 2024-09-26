#Time Complexity: O(n) 
#Space Complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        total=0
        n=len(nums)
        
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        d = [0 for _ in range(n)]
        d[0] = nums[0]
        d[1] = max(nums[0], nums[1])
        
        for i in range(2, n):
            d[i] = max(d[i - 1], d[i - 2] + nums[i])
            print(d[i])
        return d[n - 1]