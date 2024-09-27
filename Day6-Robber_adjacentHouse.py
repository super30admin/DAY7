Time complexity: O(n) linear time complexity
Space complexity: O(1) contant time complexity
Executed in leetcode: Yes
Challenges: I only coded few test cases. Still working on an alternate solution.

Comments: If the array has 1-2 elements, the maximum is returned. Else, we consider the simplest case of robbers targeting houses at
odd or even indices, before moving onto indices separated by 2 houses in between. In the latter, we consider from indices 0 and 1 in 2 
separate for loops.


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        
        # Sanity check
        if not nums:
            return 0
        
        # Suppose there is only 1-2 house(s), we find the maximum
        elif len(nums)<=2:
            return max(nums)
        
        # Check and compare houses at odd and even index
        else:
            sum1,sum2,sum3,sum4 = 0,0,0,0
            for i in range(0,n,2): # Even index
                sum1 += nums[i]
                
            for j in range(1,n,2): # Odd index
                sum2 += nums[j]
                
            for k in range(0,n,3): # Suppose [2,1,1,2], sum of 2+2 = 4 is highest
                sum3 += nums[k]
                
            for l in range(1,n,3): # Suppose [1,3,1,3,100], sum of 100+3 = 103 is highest
                sum4 += nums[l]
                
            return max(sum1,sum2,sum3,sum4)
        '''Working on alternate logic to accomodate other test cases
            for i in range(0,2):
                max(nums[i],nums[i]+nums[i+2], nums[i]+nums[i+3])
                '''
