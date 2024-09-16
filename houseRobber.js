/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums == null || nums.length == 0)return 0;
    var prev_skip = 0;
    var take = nums[0];
    for(i = 1; i< nums.length; i++){
        let temp = prev_skip;
        prev_skip = Math.max(prev_skip,take);
        take = temp + nums[i];
    }
    
    return Math.max(prev_skip,take);



    
};


//Time Complexity : n
//Space Complexity : constant