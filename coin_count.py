# // Time Complexity :O(n*m),n is the number of coins and m is amount
# // Space Complexity :O(n*m)
# // Did this code successfully run on Leetcode :no,premium account
# // Any problem you faced while coding this :not sure how to implement the logic to keep track of the path


# // Your code here along with comments explaining your approach




class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        li=[]
        if len(coins)==0:
            return 0
        li.append([0])
        #top row
        for i in range(1,amount+1):
            li[0].append(amount+1)
        for i in range(1,len(coins)+1):
            li.append([])
            # print(i)
            for j in range(amount+1):
                # print(j)
                if(j<coins[i-1]):
                     # print(li[i-1][j])
                    li[i].append(li[i-1][j])
                else:
                    
                    # print((min(li[i-1][j],li[i][j-coins[i-1]]+1)))
                    li[i].append(min(li[i-1][j],li[i][j-coins[i-1]]+1))
                # print(li)
    
        # print(li)
        # print(len(coins)+1)
        # print(amount+1)
        result=li[len(coins)][amount]
        if result>amount:
            return -1
        else:
            return result
        # print(result)
                    
                
        