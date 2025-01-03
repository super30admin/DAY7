/**
 * SC : O(1)
 * TC : O(N)
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    var num1=0,num2=0;
   for(let i=0;i<nums.length;i++){
      i%2==0 ? num1 = Math.max(num1+nums[i],num2) : num2 = Math.max(num2+nums[i],num1);
   }
   return Math.max(num1,num2);
};