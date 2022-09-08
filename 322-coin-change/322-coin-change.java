class Solution {
    public int coinChange(int[] coins, int amount) {
        
//         int dp[][] = new int [currentIndex][amount+1];
//         for(int i=0;i<N;i++)
//         for(int j=0;j<amount+1;j++)
//         dp[i][j]=-1;
        
        int ans = minCoins(coins,0,amount,new HashMap<String,Integer>());
        
        if(ans==100000)
            return -1;
        
        return ans;
    }
    private int minCoins(int coins[],int currentIndex,int amount,HashMap<String,Integer>memo){
        if(amount==0)
            return 0;
        if(currentIndex==coins.length)
            return 100000; //as amount can have greatest value as 10^4 as mentioned in the constraints 
        
        int currentCoin = coins[currentIndex];
        
        int consider = 100000;
        
        String currentKey = Integer.toString(currentIndex) + '-' + Integer.toString(amount);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        
        // if(dp[currentIndex][amount] != -1)
        // return dp[amount][currentIndex];
        
        if(currentCoin<=amount)
            consider = 1 + minCoins(coins,currentIndex,amount-currentCoin,memo);
        
        int notConsider = minCoins(coins,currentIndex+1,amount,memo);
        
        memo.put(currentKey,Math.min(consider,notConsider));
        // dp[currentIndex][amount] = Math.min(consider,notConsider);
        // return dp[currentItem][capacity];
        return memo.get(currentKey);
    }
}