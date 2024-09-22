/**
 * @param {number[]} nums
 * @return {number}
 */


// Approach: We will use the dynamic programming approach using array
// Time Complexity is O(n) where n is the length of the nums array
// Space Complexity is O(1) as we are using only constant space
var rob = function(nums) {
    if(nums.length == 1) return nums[0];
    for(let i=0;i<nums.length;i++){
        if(i == 1) nums[i] = Math.max(nums[i],nums[i-1]);
        if(i > 1){
            nums[i] = Math.max(nums[i-1], nums[i]+nums[i-2]);
        }
    }
    return nums[nums.length-1];
};


// Approach: We will use the dynamic programming approach using two variables
// Time Complexity is O(n) where n is the length of the nums array
// Space Complexity is O(1) as we are using only constant space
var rob = function(nums) {
    if(nums.length == 1) return nums[0];
    let prev = 0;
    let curr = 0;
    for(let i=0;i<nums.length;i++){
        let temp = curr;
        curr = Math.max(curr, nums[i]+prev);
        prev = temp;
    }
    return curr;
};

