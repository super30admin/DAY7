//Time: O(n), Space: O(1)
//Runs on leetcode solution accepted

var rob = function(nums) {
    if(nums.length == 0) return 0;
     let skip=0,take=nums[0];
     for(let i=1;i<nums.length;i++){
         //dont rob
         let temp = skip;
         skip = Math.max(take,skip)
         //rob
         take = temp+nums[i]
     }
     return Math.max(skip,take)
 };
