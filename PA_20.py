#LC 198 - House Robber
#Recursive Solution
#Time Complexity - Exponential (what will be the exact? 2^n?)
#Space Complexity - O(n) Again, doubt. Could you clear it out?

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0],nums[1])
        
        def helper(nums,index,total):
            #base case
            if index >= len(nums):
                return total
            #case 1 choose
            case1 = helper(nums,index+2,total+nums[index])
            #case 2 not choose
            case2 = helper(nums,index+1,total)
            return max(case1,case2)
        
        return(helper(nums,0,0))


#LC 198 - House Robber
#Dynamic Programming Approach
#Time Complexity - O(n)
#Space Complexity - O(2n)

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0],nums[1])
        #dp[c,nc]
        dp = []
        for i in range(len(nums)):
            dp.append([0,0])
        
        dp[0][0] = nums[0]
        c,nc = 0,1
        for i in range(len(nums)):
            dp[i][c] = nums[i] + dp[i-1][nc]
            dp[i][nc] = max(dp[i-1][c],dp[i-1][nc])
        return max(dp[-1][c],dp[-1][nc])



#Optimized by space
#LC 198 - House Robber
#Time Complexity - O(n)
#Space Complexity - O(1)

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0],nums[1])
        c,nc = nums[0],0
        for i in range(1,len(nums)):
            #print(c,nc)
            tnc = max(c,nc)
            c = nums[i] + nc
            nc = tnc
        return max(nc,c)