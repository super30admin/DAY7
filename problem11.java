class totalCoinChanges{

    public int coinChange(int[] nums, int amount){
        if(nums == null || nums.length == 0) return 0;

        return helper(nums, amount, 0, 0);
    }

    private int helper(int[] nums, int amount, int index, int total){
        // base
        if(amount == 0){
            return total;
        }
        if(amount < 0 || index == nums.length){
            return -1;
        }

        //logic
        int case1 = helper(nums, amount, index+1, total);

        int case2 = helper(nums, amount- nums[index], index, total+1);

        if(case1 == -1){
            return case2;
        }
        if(case2 == -1){
            return case1;
        }
        return Math.min(case1, case2);
    }

    public static void main(String[] args) {
        totalCoinChanges tcc = new totalCoinChanges();
        int[] nums = {1,2,5};
        int amount = 11;
        System.out.println(tcc.coinChange(nums, amount));
    }
}