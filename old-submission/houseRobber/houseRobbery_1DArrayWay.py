class Solution:
    
    def __init__(self):
        self.robList = None
    
    def getMaxRobbery(self,nums,index):
        
        for index in range(len(nums)-1,-1,-1):
            
            # Case 1: not selected
            case1 = 0
            if index+1 < len(nums):
                case1 = self.robList[index+1]
            
            # Case 2: selected
            case2 = nums[index]
            if index+2 < len(nums):
                case2 = case2 +self.robList[index+2]
            
            # Set the max in robList[index]
            self.robList[index] = max(case1,case2)    
        
    def getSolution(self,nums):

        self.robList = [None] * (len(nums)) 
        self.getMaxRobbery(nums,(len(nums)-1))
        return self.robList[0]

sol = Solution()
#print(sol.getSolution([6,9,8,1,1,5])) #19
print(sol.getSolution([2,7,9,3,1]))

#[1,2,3,1]
#[2,7,9,3,1]