class Solution {
    public int jump(int[] nums) {
        return minJumps(nums,0,new HashMap<Integer,Integer>());
    }
    private int minJumps(int nums[],int currentIndex,HashMap<Integer,Integer>memo){
        
        if(currentIndex>=nums.length-1)
            return 0;
        
         if(nums[currentIndex]==0)
             return 10001;
        
        int ans =10001;
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int currentJump = nums[currentIndex];
        
        for(int x=1;x<=currentJump;x++){
            int tempAns = 1 + minJumps(nums,currentIndex+x,memo);
            ans = Math.min(ans,tempAns);
        }
        
        memo.put(currentKey,ans);
        return memo.get(currentKey);
    }
}