class Solution {
    public int rob(int[] nums) {
        // int a = maxMoney(nums,0,n-1,new HashMap<Integer,Integer>());
        // int b = maxMoney(nums,1,n,new HashMap<Integer,Integer>());
        // return maxMoney(nums,0,new HashMap<Integer,Integer>());
        HashMap<Integer,Integer>memo=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer>memo1=new HashMap<Integer,Integer>();
        // int n = nums.length;
        if (nums.length==1)
            return nums[0];
        int a = maxMoney(nums,0,nums.length-1,memo);
        int b = maxMoney(nums,1,nums.length,memo1);
        return Math.max(a,b);
    }
    private int maxMoney(int nums[] , int currentHouse,int endHouse,HashMap<Integer,Integer>memo){
        
        if(currentHouse>=endHouse)
            return 0;
        
        Integer currentKey = currentHouse;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int rob = nums[currentHouse]+maxMoney(nums,currentHouse+2,endHouse,memo);
        int noRob = maxMoney(nums,currentHouse+1,endHouse,memo);
        
        memo.put(currentKey,Math.max(rob,noRob));
        return memo.get(currentKey);
    }
    }
