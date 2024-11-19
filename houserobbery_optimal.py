# // Time Complexity :O(n)
# // Space Complexity :O(1)

class Solution:
    
    def rob(self, nums: List[int]) -> int:
        skip=0
        take=nums[0]
        for i in range(1,len(nums)):
            temp=skip
            skip=max(skip,take)
            take=temp+nums[i]
            print(skip,take)
        return max(skip,take)