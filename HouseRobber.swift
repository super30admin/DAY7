// Time Complexity : n^m
// Space Complexity : n^m
// Did this code successfully run on Leetcode : No. Time limit exceeded
// Any problem you faced while coding this : mistakenly put the base case


// Your code here along with comments explaining your approach
//Recursive approach to choose and not choose a house then get the max of two cases 

class Solution {
    func rob(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        return helper(nums,0,0)
    }
    
    private func helper(_ nums: [Int], _ startIndex: Int, _ amount: Int) -> Int {
        //base
        if startIndex >= nums.count {
            return amount
        }
        
        //logic
        //choose a coin
        let case2 = helper(nums, startIndex+2, nums[startIndex] + amount)
        //not choose a coin
        let case1 = helper(nums, startIndex+1, amount)
        
        //result
        return max(case1,case2)
    }
}

//DP soulution
//previous

class Solution {
    func rob(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        var choose = 0
        var notChoose = 0
        var prevChoosen = 0
        for i in 0..<nums.count {
           //choose
            choose = notChoose + nums[i]
           //last not choosen + current house
           //not choose
            notChoose = max(notChoose,prevChoosen)
           // last maximum of choose and not choose
            prevChoosen = choose
        }
        
        return max(choose, notChoose)
    }

}