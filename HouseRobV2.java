
public class HouseRobV2 {
	
public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int skip = 0;
        int take = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int curr_skip = Math.max(skip, take);
            int curr_take = skip + nums[i];
            
            skip = curr_skip;
            take = curr_take;
        }
        
        return Math.max(skip, take);
        
    }

}
