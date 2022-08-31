class Solution {
    public int fib(int n) {
        return nthfib(n , new HashMap<Integer , Integer>());
        
    }
    
    private int nthfib(int n , HashMap<Integer , Integer> memo){
        
        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        int currentkey = n;
        
        if(memo.containsKey(n))
            return memo.get(currentkey);
        
        int a = nthfib(n-1,memo);
        int b = nthfib(n-2,memo);
        
        memo.put(currentkey , a+b);
        return a+b;
    }
}