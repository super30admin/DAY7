// TC: O(n)
// SC: O(1)
public class Problem2 {
    public int rob(int[] nums) {
        int m = nums.length;
        if(m==1) return nums[0];

        int prev = nums[0];
        int current = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int temp = current;
            current = Math.max(current, nums[i]+prev);
            prev = temp;
        }
        return current;
    }
}
