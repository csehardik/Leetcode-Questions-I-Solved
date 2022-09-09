class Solution {
    public int maxProfit(int[] prices) {
        
        // int dp[][][]=new int[currentDay+1][1][1];
         int[][][] arr = new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++)
                    arr[i][j][k]=-1;
            }
        }
        return maxProfit(prices,0,1,1,arr);
    }
    private int maxProfit(int prices[],int currentDay,int canBuy,int transactionCount,int memo[][][]){
        
        // if(currentDay>=prices.length || transactionCount == 0)
        if(currentDay>=prices.length || transactionCount<=0)
            return 0;
        
        if(memo[currentDay][canBuy][transactionCount]!=-1)
                return memo[currentDay][canBuy][transactionCount];
        
        
        if(canBuy==1){
            int idle = maxProfit(prices,currentDay+1,canBuy,transactionCount,memo);
            int buy = -prices[currentDay]+maxProfit(prices,currentDay+1,0,transactionCount,memo);
            memo[currentDay][canBuy][transactionCount] = Math.max(idle,buy);
            return memo[currentDay][canBuy][transactionCount];
        }
        else{
            int idle =  maxProfit(prices,currentDay+1,canBuy,transactionCount,memo);
            int sell = prices[currentDay] + maxProfit(prices,currentDay+1,1,transactionCount-1,memo);
          
            memo[currentDay][canBuy][transactionCount] = Math.max(idle,sell);
            return memo[currentDay][canBuy][transactionCount];

            
        }
        
        
    }
}