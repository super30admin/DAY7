/**
 Approach: Dynamic Programming whith 0/1 methodology without extra space

 Working:
     declare 2 variable
     skip - case 0
     take - case 1
     assign the skip with 0 and take with first element in input array
     loop through the array  1 ... n
         assign tempSkip = skip//since previous skip is change int
         case 0: do not choose the current house
            skip for case 0 = maximum of previous robbed 0 and 1 case i.e(skip, take)

         case 1: choose the current house
             take for case 1
             = previous i.e(tempSkip) house not chose value (i.e case 0 -> skip) + current house robbed amount

     return the maximum case 0/1 of the last robbed house i.e(max skip and take)

 Time Complexity:O(n)
 Space Complexity: O(1)
 */

class HouseRobberDpWithConstantSpace {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int skip = 0;
        int take = nums[0];

        for(int i=1;i<nums.length; i++) {
            //storing the previous value of skip to use in the choose case i.e case 1
            int tempSkip = skip;
            //case 0
            skip = Math.max(skip, take);
            //case 1
            take = tempSkip+nums[i];
        }

        return Math.max(skip, take);

    }
}