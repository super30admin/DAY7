/*
Time Complexity: O(m*n)

Space Complexity: O(n) 
*/

#include<iostream>
#include<vector>

class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        int numOfRows = coins.size() + 1;
        int numOfColumns = amount + 1;
        int arr [numOfColumns];
        int result = 0;
        for (int i=1; i < numOfColumns; i++){
            arr[i] = 99999;
        }
        arr[0] = 0;
        for (int i = 1; i < numOfRows; i++){
            for(int j=1; j < numOfColumns; j++){
                if (j >= coins[i - 1]){
                    arr[j] = std::min(arr[j], 1 + arr[j - coins[i - 1]]);
                }
            }
        }
        result = arr[numOfColumns - 1];
        if (result >= 99999) return -1;
        return result;
    }
};

int main(){
    Solution sol = Solution();
    std::vector<int> arr {1,2,5};
    int k = 11;
    int exp_res = 3;
    int res = sol.coinChange(arr, k);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }

    arr = {2};
    k = 3;
    exp_res = -1;
    res = sol.coinChange(arr, k);
    if (res == exp_res){
        std::cout << "Answer matches: " << res << ", Expected res: " << exp_res << std::endl;
    } else {
        std::cout << "Answer do not match: " << res << ", Expected res: " << exp_res << std::endl;
    }
}