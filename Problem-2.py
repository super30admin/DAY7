#Approach
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call and find the min.


# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(1)


from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.helper(nums, 0, 0)

    def helper(self, nums, index, money):
        if index >= len(nums):
            return money
        case0 = self.helper(nums, index + 1, money)
        case1 = self.helper(nums, index + 2, money + nums[index])

        return max(case0, case1)


class Solution:
    def rob(self, nums: List[int]) -> int:
        n= len(nums)+1
        if n==1:
            return nums[0]
        dp=[0]*n
        dp[0] = nums[1]

        dp[1] = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            print(dp,i)
            dp[i] = max(dp[i-1],nums[i]+dp[i-2])

        return dp[n-1]

class Solution:
    def rob(self, nums: List[int]) -> int:
        n= len(nums)+1
        if n==1:
            return nums[0]

        last_but_two = 0
        prev = nums[0]
        curr = 0

        for i in range(1,len(nums)):
            curr = max(prev,nums[i]+last_but_two)
            last_but_two,prev = prev,curr
        return curr

s = Solution()
print(s.rob([1,2,3,1]))