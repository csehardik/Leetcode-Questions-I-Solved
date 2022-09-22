class Solution {
    public boolean canJump(int[] nums) {
        int overallMax=0;
        for(int i=0;i<nums.length;i++){
            if(overallMax<i)
                return false;
            overallMax = Math.max(overallMax,i+nums[i]);
        }
        return true;
    }
}