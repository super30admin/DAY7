class Solution:
    
    def getMaxRobbery(self,nums,index):
        
        # base case
        if index >= len(nums):
            return 0
        
        # actual logic
        # Case 1: Ignore index
        case1 = self.getMaxRobbery(nums, index+1)
        
        # Case 2: Select index
        case2 = (nums[index]) + self.getMaxRobbery(nums, index+2)
        
        # Return max(case1,case2)
        return max(case1,case2)
    
    def getSolution(self,nums):
        return self.getMaxRobbery(nums,0)

sol = Solution()
#print(sol.getSolution([6,9,8,1,1,5])) #19
print(sol.getSolution([2,7,9,3,1]))