class Solution {
    public int tribonacci(int n) {
        return nthTrib(n , new HashMap<Integer,Integer>());
    }
    
    private int nthTrib(int n , HashMap<Integer,Integer>memo){
        if(n<=1)
            return n;
        
        if(n==2)
            return 1;
        
        int currentKey=n;
        
        if(memo.containsKey(currentKey))
           return memo.get(currentKey);
        
        //if(memo.containsKey(n))
          //  memo.get(n);
        
        int a = nthTrib(n-1,memo);
        int b = nthTrib(n-2,memo);
        int c = nthTrib(n-3,memo);
        
        
        memo.put(currentKey,a+b+c);
        return memo.get(currentKey);
        
    }
}