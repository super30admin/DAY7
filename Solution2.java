public class Solution2 {
    public int rob(int[] nums) {
        int[] total = new int[nums.length + 1];
        total[0] = 0;
        total[1] = nums[0];
        for(int i = 2; i < total.length; i++){
            total[i] = Math.max(total[i-1], total[i-2] + nums[i-1]);
        }
        return total[nums.length];
    }
}
