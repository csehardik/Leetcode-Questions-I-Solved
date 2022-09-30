class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        
        for(int x:nums){
            max=Math.max(max,x);
        }
        
        int frequency[] = new int[max+1];
        Arrays.fill(frequency,0);
        for(int x:nums){
            frequency[x] += 1;
        }
        
        return maxPoints(frequency,0,new HashMap<Integer,Integer>());
    }
    private int maxPoints(int frequency[],int currentIndex,HashMap<Integer,Integer>memo){
        
        if(currentIndex>=frequency.length)
            return 0;
        
        int currentKey=currentIndex;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int delete = currentIndex*frequency[currentIndex] + maxPoints(frequency,currentIndex+2,memo);
        int noDelete = maxPoints(frequency,currentIndex+1,memo);
        
        memo.put(currentKey,Math.max(delete,noDelete));
        return memo.get(currentKey);
        
    }
}