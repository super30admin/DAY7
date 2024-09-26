// Time Complexity :o(n)
// Space Complexity :O()
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    public int rob(int[] num) {
    int rob = 0; 
    int notrob = 0;
    for(int i=0; i<num.length; i++) {
        int currob = notrob + num[i]; 
        notrob = Math.max(notrob, rob); 
        rob = currob;
    }
    return Math.max(rob, notrob);
}
}