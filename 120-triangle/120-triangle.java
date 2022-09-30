// top down approach / memoized code

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minSum(triangle,0,0,new HashMap<String,Integer>());
    }
public int minSum(List<List<Integer>> arr,int row,int j,HashMap<String,Integer>memo)  // [ here j = column ]
    {
        if(row==arr.size()-1) 
            return arr.get(row).get(j);
    
    String currentKey = Integer.toString(row) + '-' + Integer.toString(j);
    
    if(memo.containsKey(currentKey))
        return memo.get(currentKey);
        
        int down = arr.get(row).get(j) + minSum(arr,row+1,j,memo);
        int diagonal = arr.get(row).get(j) + minSum(arr,row+1,j+1,memo);
        
    memo.put(currentKey,Math.min(down,diagonal));
        return memo.get(currentKey);
    }
}