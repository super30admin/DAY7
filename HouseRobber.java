
class Solution {
    public int rob(int[] nums) {
        int[] maxMoney = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxMoney[i] = nums[i];

            for (int j = i - 2; j >= 0; j--) {
                maxMoney[i] = Math.max(maxMoney[i], maxMoney[j] + nums[i]);
            }
        }
        int max = maxMoney[0];
        for (int i = 1; i < maxMoney.length; i++)
            if (maxMoney[i] > max)
                max = maxMoney[i];
        return max;
    }
}