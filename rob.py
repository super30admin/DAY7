#Time Complexity=O(n)
#Space Complexity=O(2n)=O(n)
#Ran successfully on leetcode:Yes
#We check whihc of the sum is greater , is it numbers at even index or odd index.


class Solution:
    def rob(self, nums: List[int]) -> int:
        SumEven=0
        SumOdd=0
        for i in range(len(nums)):
            if i%2==0:
                  SumEven=max(SumEven+nums[i],SumOdd)
            else:
                  SumOdd= max(SumOdd+nums[i],SumEven) 
        return max(SumEven,SumOdd)
            
