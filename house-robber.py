# Time complexity: O(n)
# Space Complexity: O(1) not O(n) since we are overwriting input arr
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        for i in range(len(nums)-1, -1, -1):
            if i+1 >= len(nums):
                notchoose_max = 0
            else:
                notchoose_max = nums[i+1]
            if i+2 >= len(nums):
                choose_max = nums[i]
            else:
                choose_max = nums[i] + nums[i+2]
            nums[i] = max(notchoose_max, choose_max)
        return nums[0]

# Print path
class Solution:
    def rob(self, nums: List[int]) -> int:
        pathArr = [0] * len(nums)
        input = nums.copy()
        for i in range(len(nums)-1, -1, -1):
            if i+1 >= len(nums):
                notchoose_max = 0
            else:
                notchoose_max = nums[i+1]
            if i+2 >= len(nums):
                choose_max = nums[i]
            else:
                choose_max = nums[i] + nums[i+2]
            if choose_max > notchoose_max:
                pathArr[i] = 1
                nums[i] = choose_max
            else:
                nums[i] = notchoose_max
        i = 0
        path = []
        while i < len(pathArr):
            if pathArr[i] == 1:
                path.append(input[i])
                i += 2
            else:
                i += 1
        print(path)

        return nums[0]


#Brut force with recursion
#Time complexity: O(2^n)
#Space complexity: O(n) , not sure
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        return self.getMax(nums, 0)
    
    def getMax(self, nums: List[int], index: int):
        # base
        if index >= len(nums): return 0

        #choose
        chooseMax = nums[index] + self.getMax(nums, index+2)
        #not choose
        notChooseMax = self.getMax(nums, index+1)
        return max(chooseMax, notChooseMax)
    
# Memoization
#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        memoizationArr = [-1] * len(nums)
        return self.getMax(nums, 0, memoizationArr)
    
    def getMax(self, nums: List[int], index: int, memoizationArr: [int]): 
        # base
        if index >= len(nums): return 0
        if memoizationArr[index] != -1: return memoizationArr[index]
        #choose
        chooseMax = nums[index] + self.getMax(nums, index+2, memoizationArr)
        #not choose
        notChooseMax = self.getMax(nums, index+1, memoizationArr)
        maxAmt = max(chooseMax, notChooseMax)
        memoizationArr[index] = maxAmt
        return maxAmt