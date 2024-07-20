//Brute force
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int rob(int[] nums) {
        int amount = 0;
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length<3){
            if(nums[0]>nums[1]){
                return nums[0];
            }else{
                return nums[1];
            }
        }else{
            int amount1 = 0;
            int amount2 = nums[0];
            for(int i=1;i<nums.length;i++){
                int temp = amount2;
                amount2 = Math.max(amount2, amount1+nums[i]);
                amount1 = temp;
            }
            return amount2;
        }
    }
}

//Just a small Improvement with Dynamic Programming
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums)); // Output: 12
    }
}
