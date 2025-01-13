class Solution:
    
    def minCoin(self,coinList,index,amount,minCount):
        
        # Base Case
        if amount == 0: 
            return minCount
        
        elif amount <0 or index == len(coinList):
            return -1
        # Logic Case
    
        # Case 1: ignore the index/coin from the list
        case1 = self.minCoin(coinList, index+1, amount, minCount)
        
        # Case 2: accept the index/coin from the list
        case2 = self.minCoin(coinList, index, (amount-coinList[index]), minCount+1)
        
        if case1 == -1: 
            return case2
        
        elif case2 == -1:
            return case1
        
        else:
            return min(case1,case2)
    
    def getSolution(self,coinList,amount):
        return self.minCoin(coinList, 0, amount,0)

sol = Solution()
print(sol.getSolution([1,5,7], 18))