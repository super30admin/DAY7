//TC: O(n)
//SC: O(n)
//Did it run on leetcode: Yes
public class Solution_Rob {
    public int findMax(int[] max, int i){
        if( i >= max.length)
            return 0;

        return Math.max(max[i], findMax(max, i+1));
    }

    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] max = new int[nums.length];
        max[nums.length-1] = nums[nums.length-1];
        max[nums.length-2] = nums[nums.length-2];
        for(int i = nums.length-3; i >= 0; i--){
            max[i] = nums[i] + findMax(max, i+2);
        }

        return Math.max(max[0], max[1]);

    }
}
