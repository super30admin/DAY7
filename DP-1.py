#Problem 1: Coin Change
#Time Complexity O(N*A), A the amount and N length of coins
#Space Complexity O(N)
#Worked on leetcode? : Yes
'''
Main idea: We ask ourselves how can we divide the problem into subproblems such that
these subproblems can help us getting the next subproblem until the final answer.
The idea is to initiate an array of length "amount" we're trying to reach.
Then, after initialising 0 with 0 coins, we start with One. We check ,for each coins
if Best(1-coins)+1 is better than our min right now (initialise to inf). We continue
for each index (subproblem amount) if best(index-coins)+1 is better than our min now,
for each coins. We do that until we reach the amount desired.
This works because each increment of subproblem is 1, so there must be a way to
reach the index from previous indices since index-coin will always be solved before.
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #edge case
        if not amount:
            return 0
        # 0,1,2,....,amount. the index represent what we want to reach
        subproblems=[float("inf")]*(amount+1)
        subproblems[0]=0

        for i,sub in enumerate(subproblems):
            for coin in coins:
                #Obviously, if difference is smaller, no need to check the coin
                if i-coin>=0:
                    subproblems[i]=min(subproblems[i],subproblems[i-coin]+1)

        if subproblems[-1]==float('inf'):
            return -1
        return subproblems[-1]

#Problem 2: House Robber
#Time Complexity O(N) ( O(2*N) but we ignore the constant)
#Space Complexity O(N)
#Worked on leetcode? : Yes

'''
idea: divide into subproblems, how much can I rob until house 0, house 1, house 2. at each index, I can check, is it better to not rob this house, and take
keep the same amount max amount at the index before? or rob this house and take the max amount as the one before the one before? Since when traversing the previous
subproblems will already be solved, so no need to worry what is the best combination before we get to this house and no need to worry that we took a adjacent house in the subproblems. We only can't take both the previous one and the one right now. we initialise 0 at 0 and house one at value 1,
since obviously if there's only one house we rob it.
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        #edge case
        if not nums:
            return 0
        subproblems=[0]*(len(nums)+1)
        subproblems[1]=nums[0]
        #careful, the index of the subproblem represents the number of house, not the house index
        #for the house index we do subproblems_index-1
        for i in range(2,len(subproblems)):
            #i-2 is the one before the one before subproblem (or house)
            #or is better to just ignore this house?
            subproblems[i]=max(nums[i-1]+subproblems[i-2],subproblems[i-1])
        return subproblems[-1]
