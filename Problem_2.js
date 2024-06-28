// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Solved it first using brute force recursive solution and then memoized it. Ran into timeout error. 
Then applied the 1D matrix solution by storing the possible solutions between given options. Once all the values had been calculated, returned the last value from the array. 
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {    

    
    // var robHelper =(nums, memo = {}) => {
    //     if(nums in memo) return memo[nums];
    //     if(nums.length === 0) return 0;
    //     if(nums.length === 1) return nums[0];

    //     memo[nums] = Math.max(nums[0] + robHelper(nums.slice(2)), robHelper(nums.slice(1)));
    //     return memo[nums]
    // }

    // return robHelper(nums)

    let possibleSumArr = []; 
        possibleSumArr[0] = 0;
        possibleSumArr[1] = nums[0];

    for(let i=2; i<=nums.length; i++){
        possibleSumArr[i] = Math.max(nums[i-1]+possibleSumArr[i-2], possibleSumArr[i-1]);
    }
    return possibleSumArr[possibleSumArr.length -1];
};