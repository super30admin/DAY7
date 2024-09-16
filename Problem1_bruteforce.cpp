//Space Complexity: O(1)
//Time Complexity: O(2^n), where n is the length of the array.
//Time Limit exceeded  on leetcode.

class Solution {

private:
    int helper(vector<int>& coins, int amount, int index, int min){
        //base case
        
        if(amount==0) return min;
        if(amount < 0 || index==coins.size()) return -1;
        
        //logic
    
        //choosing a coin
        int choosing_a_coin = helper(coins, amount-coins.at(index), index, min+1);
        //not choosing a coin
        int not_choosing_a_coin = helper(coins, amount, index+1, min);
        
        if(choosing_a_coin == -1) return not_choosing_a_coin;
        if(not_choosing_a_coin == -1) return choosing_a_coin;
        return std::min(choosing_a_coin,not_choosing_a_coin);
    }

public:
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size()==0) return 0;
        return helper(coins,amount,0,0);
    }

};