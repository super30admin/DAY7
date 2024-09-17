from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
          return 0

        chosen,notchosen = 0,0
        for i in range(len(nums)):
          temp = notchosen
          notchosen = max(chosen,notchosen)
          chosen = temp + nums [i]
        return max(chosen,notchosen)

if __name__=="__main__":
  input=[1,2,3,1]
  s=Solution()
  print(s.rob(input))
