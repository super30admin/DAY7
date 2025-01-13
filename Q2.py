######### House Robber

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# go through and compute max cost if we were to rob and if we werent. 

def house_robber(cost):
    if not cost:
            return 0
            
    dp = [[0, 0] for _ in range(len(cost))]
    dp[0][0] = 0
    dp [0][1] = cost[0]
        
    for i in range(1,len(cost)):
        dp[i][0]= max(dp[i-1][0],dp[i-1][1])
        dp[i][1] = dp[i-1][0] + cost[i]
    return max(dp[-1][0], dp[-1][1])


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes
# Any problem you faced while coding this : No

# can further optimise using 3 variables only

def house_robber(cost):
    if not cost:
        return 0
    
    didNotRob = 0
    didRob = cost[0]
        
    for i in range(1,len(cost)):
        temp = didNotRob
        didNotRob = max(didNotRob,didRob)
        didRob = temp + cost[i]
    return max(didNotRob, didRob)

