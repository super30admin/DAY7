class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0 :
            return 0
        n = len(nums) 
        skip = 0
        take = nums[0]
        for i in range(1,n):
            temp = skip
            skip = max(skip,take)
            take = temp + nums[i]
        return max(skip,take)
        