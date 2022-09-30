class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<Integer>result=new ArrayList<>();
        // int value =1;
        // for(int j=0;j<=rowIndex;j++){
        //     result.push(value);
        //     value=value*((rowIndex-j)/(j+1));       
        // }
        //     return result;
        
          List<Integer> result = new ArrayList();
        long val = 1;
        for(int j = 0;j<=rowIndex;j++){
            result.add((int)val);
            val = val*(rowIndex-j)/(j+1);
        }
        return result;
        
    }

}