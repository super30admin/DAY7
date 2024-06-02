# Time = O(n)
# Sapce = O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return -1 
        # Init prev houses 
        prev1, prev2 = 0 , 0 
        for num in nums:
            # find max if current house is included 
            current = max(prev1, prev2 + num)
            # move to next house 
            prev2 = prev1 
            prev1 = current 
        return prev1
        