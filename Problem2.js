//House Robber (LC 198)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes initially I had problems with using a object instead of a map

//Use local counter to calculate amount and store max amount in temp. Then set max and go on to the next number. Basically maintaing two variables and setting max each time.
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums.length === 0 || nums === null){
        return 0;
    }
    let output = 0;
    let maxOutput = 0;
    for(let i=0;i<nums.length;i++){
        let temp = maxOutput;
        maxOutput = Math.max(output + nums[i], maxOutput);
        output = temp;
    }
    return maxOutput;
};