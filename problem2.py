
class Solution:
    # time: o(n)
    # space: o(n)
    
    def rob1(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]

        dp = [0] * len(nums)

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        
        return dp[-1]

    # time: o(n)
    # space: o(1)
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]

        prev = nums[0]
        curr = max(nums[0], nums[1])
        dp = curr

        for i in range(2, len(nums)):
            dp = max(curr, nums[i] + prev)
            prev = curr
            curr = dp
        
        return dp
        