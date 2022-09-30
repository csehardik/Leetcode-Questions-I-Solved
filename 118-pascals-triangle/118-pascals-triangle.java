class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==0)return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i =1;i<numRows;i++){
            List<Integer>currentList=new ArrayList<>();
            currentList.add(1);
            for(int j=1;j<i;j++){
                currentList.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            currentList.add(1);
            result.add(currentList);
        }
        return result;
    }
}