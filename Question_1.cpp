#include<bits/stdc++.h>
using namespace std;
#include <iostream>
#include <vector>

int coinChange(vector<int>& coins, int amount) {
    if(amount==0) return 0;
    sort(coins.begin(),coins.end(),greater<int>());
    int n=coins.size();
    int dp[amount+1][n];
    memset(dp,-1,sizeof(dp));
    for(int i=0;i<=n-1;i++) dp[0][i]=0;
    for(int i=1;i<=amount;i++){
        if(i%coins[n-1]==0) dp[i][n-1]=i/coins[n-1];
    }
    for(int i=n-2;i>=0;i--){
        for(int j=1;j<=amount;j++){
            if(j<coins[i]||(dp[j-coins[i]][i]==-1&&dp[j][i+1]==-1)) {
                dp[j][i]=dp[j][i+1];
                continue;
            }
            if(dp[j-coins[i]][i]==-1) dp[j][i]=dp[j][i+1];
            else if(dp[j][i+1]==-1) dp[j][i]=dp[j-coins[i]][i]+1;
            else dp[j][i]=min(dp[j][i+1],dp[j-coins[i]][i]+1);
        }
    }
    return dp[amount][0];
}
int main(){
    vector<int> coins = {1,2,5};
    int amount = 11;
    cout<<coinChange(coins,amount);
    return 0;
}