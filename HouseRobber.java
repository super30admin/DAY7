//The approach here is to use tabulation to optimize the exhaustive approach.
//we used two variabes to store the previous and the current value.
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int prev = nums[0];
        if(n==1) return prev;
        int cur = Math.max(prev, nums[1]+0);
        for(int i= 2; i<n; i++){
            int temp = cur;
            cur = Math.max(temp, nums[i]+prev);
            prev = temp;
        }
    return cur;
    }
}