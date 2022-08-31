class Solution {
    public int climbStairs(int n) {
        return totalways(0,n, new HashMap<Integer , Integer>());
    }
    
    private int totalways(int currentstair , int targetstair , HashMap <Integer , Integer >memo){
        if(currentstair == targetstair)
            return 1;
        
        if(currentstair > targetstair)
            return 0;
        
        int currentkey=currentstair;
        
        if(memo.containsKey(currentkey))
            return memo.get(currentkey);
        
        int onejump = totalways(currentstair+1,targetstair ,memo);
        int twojumps = totalways(currentstair+2 , targetstair ,memo);
        
        memo.put(currentkey , onejump+twojumps);
        return onejump+twojumps;
    }
}