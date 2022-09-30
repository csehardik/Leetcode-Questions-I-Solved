class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>() ;
        if(numRows==0)
            return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer>currentlist = new ArrayList<>();
            currentlist.add(1);
            for(int j=1;j<i;j++){
                currentlist.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            currentlist.add(1);
            result.add(currentlist);
        }
        return result;
    }
}