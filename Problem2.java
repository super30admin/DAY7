public class Problem2 {
    public int rob(int[] nums) {
        int n = nums.length;
        return houserobberDPSpaceOptimized(nums);
    }
    //TC :O(2^N)
    int recurHelper (int[]  nums,int Idx,int totalRobbings){

        // base conditions
        if(Idx >=nums.length){
            return totalRobbings;
        }

        //chose the index
        int robbed = nums[Idx];

        int notChosen = recurHelper(nums,Idx+1,totalRobbings);

        //do not chose the index
        int chose = recurHelper(nums,Idx+2,totalRobbings+robbed);



        return Math.max(notChosen, chose);
    }

    //TC :O(N)
    //SC :O(N)
    int houserobberDP (int[]  nums){

        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];


        for(int i=2 ;i<=n;i++){
            int robbed = nums[i-1];


            //not chosen
            int notChosen = dp[i-1];

            //chosen
            int chosen = robbed + dp[i-2];

            dp[i] = Math.max(notChosen,chosen);

        }

        return dp[n];
    }

    //TC :O(N)
    //SC :O(1)
    int houserobberDPSpaceOptimized (int[]  nums){

        int n = nums.length;

        int previous = 0;
        int current = nums[0];


        for(int i=2 ;i<=n;i++){
            int robbed = nums[i-1];


            //not chosen
            int notChosen = current;

            //chosen
            int chosen = robbed + previous;
            previous = notChosen;

            current = Math.max(notChosen,chosen);

        }

        return current;
    }
}
