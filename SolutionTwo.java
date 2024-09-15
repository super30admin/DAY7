// Time complexity: O(n) where n is the number of houses
// Space complexity: O(1) 

class SolutionTwo {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
