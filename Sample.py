##############198. House Robber#
#######################################################################################################################################################################
// Time Complexity : done in 2 ways - recursion: 2^(number of houses) and matrix: number of houses
// Space Complexity : recursion: not sure for recursion ad matrix: n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : solved after class, so have better idea


// Your code here along with comments explaining your approach in three sentences only
1 way used is recursion and another is once brute force place is played out implemented matrix 

##############recursion###############
class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.bruteforce(nums, 0)

    def bruteforce(self,nums,idx):
        #base
        if idx>=len(nums):
            return 0
        #select
        case1=nums[idx] + self.bruteforce(nums, idx+2)
        #no select
        case2=0 + self.bruteforce(nums, idx+1)
        return max(case1,case2)


###############Matrix##############
class Solution:
    def rob(self, nums: List[int]) -> int:
        mat=[0]*(len(nums)+1)
        mat[1]=max(mat[0],nums[0])
        print(mat)
        for i in range(2,len(nums)+1):
            mat[i]=max(mat[i-1],nums[i-1]+mat[i-2])
        print(mat)
        return mat[-1]        
        

#############322. Coin Change###################################################################################################################################################################################


// Time Complexity : done in 2 ways - recursion: 2^(number of coins+target) and matrix: number of coins X target
// Space Complexity : recursion: not sure for recursion ad matrix: mXn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : solved after class, so have better idea


// Your code here along with comments explaining your approach in three sentences only
1 way used is recursion and another is once brute force place is played out implemented matrix 

##############Recursion##############
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        idx=0
        ans=self.bruteforce(coins, amount, idx)
        if ans==99999:
            return -1
        else:
            return ans

    def bruteforce(self,coins: List[int], amount: int, idx: int) -> int:
        print(coins,'amount',amount,' index',idx)
        #base case
        if amount==0:
            print('amount=0')
            return 0
        if amount<0 or idx==len(coins):
            print('base else amount',amount,' coin index',idx)
            return 99999

        #logic
            #select case
        print('case 1 pre')
        case1=1+self.bruteforce(coins,amount-coins[idx],idx)
        print('case1 post')
            #not select
        case2=0+self.bruteforce(coins,amount,idx+1)
        return min(case1,case2)


        


###############Matrix##############

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m=amount
        n=len(coins)
        mat=[[99999 for j in range(m+1)] for i in range(n+1)]
        mat[0][0]=0
        #print(mat)
        for i in range(1,n+1):
            for j in range(m+1):
                if j<coins[i-1]:
                    mat[i][j]=mat[i-1][j]
                else:
                    mat[i][j]=min(mat[i-1][j],mat[i][j-coins[i-1]]+1)
        #print(mat)
        if mat[n][m]==99999:
            return -1
        else:
            return mat[n][m]
        
        




  