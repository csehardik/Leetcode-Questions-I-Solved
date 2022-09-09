class Solution {
    public int maxProfit(int[] prices,int fee) {
        return bestBuy(prices,0, 1, new HashMap<String,Integer>(),fee);
    }
    public int bestBuy(int[] prices, int currentDay, int canBuy,  HashMap<String,Integer> memo,int fee){
        
        // if(currentDay >= prices.length || transCount<=0)
        if(currentDay >= prices.length)
            return 0;
    
        // String currentKey = Integer.toString(currentDay) + "" + Integer.toString(canBuy) + "" + Integer.toString(transCount);
        // We Can't Use this Approach as it is giving TLE
        
        String currentKey = currentDay + "_" + canBuy;
        
        if(memo.containsKey(currentKey))
                return memo.get(currentKey);
        
        if(canBuy==1){
            int idle = bestBuy(prices, currentDay + 1, canBuy, memo,fee);
            int buy = bestBuy(prices, currentDay + 1, 0, memo,fee) - prices[currentDay];
            
            memo.put(currentKey,Math.max(idle,buy));
            return memo.get(currentKey);
        }
        else
        {
            int idle = bestBuy(prices, currentDay + 1, canBuy,  memo,fee);
            int sell = bestBuy(prices, currentDay + 1, 1,  memo,fee) + prices[currentDay]-fee;
            
            memo.put(currentKey,Math.max(idle,sell));
            return memo.get(currentKey);
        }
            
    }
}