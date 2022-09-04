class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums,0,target,new HashMap<String,Integer>());
    }
    private int totalWays(int nums[],int currentIndex,int target,HashMap<String,Integer>memo){
        
        if(currentIndex == nums.length && target == 0)
            return 1;
        if(currentIndex == nums.length && target != 0)
            return 0;
        
        String currentKey = Integer.toString(currentIndex) + '-' + Integer.toString(target);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int positive = totalWays(nums,currentIndex+1,target-nums[currentIndex],memo);
        int negative = totalWays(nums,currentIndex+1,target+nums[currentIndex],memo);
        
        memo.put(currentKey,positive+negative);
        return memo.get(currentKey);
    }
}