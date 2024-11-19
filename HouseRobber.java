//In this problem the Optimal solution takes about O(n) time where n is the number of house and space is constant O(1)
//Bruteforce time complexity would be O(n^2) and still the space complexity if O(1)
class Solution {
  public int rob(int[] nums) {
    if(nums.length == 0)
      return 0;
    else{
      return maxLooted(nums)
      //return recursiveHelper(0,0,nums);
    }
  }

  //Optimal Solution
  private int maxLooted(int[] nums){
    int prev_skip=0,prev_take=0;
    for(int i = 0;i<nums.length;i++){
      int temp = prev_skip;
      prev_skip = Math.max(prev_skip,prev_take);
      prev_take = nums[i] + temp;
    }
    return Math.max(prev_skip,prev_take);
  }

  //Bruteforce
  private int recursiveHelper(int index, int sum, int[] nums){
    if(index >= nums.length)
      return sum;
    else{
      //If we are not choosing the house, we keep sum the same
      int case1 = recursiveHelper(index+1, sum, nums);
      //if we are choosing the house then we increase the index by 2 as we should not visit the
      // neighbour house and increase the sum
      int case2 = recursiveHelper(index+2,sum+nums[index],nums);
      return Math.max(case1,case2);
    }
  }
}