class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer>memo = new HashMap<Integer,Integer>();
        
        for(int currentNum:nums1){
            if(!memo.containsKey(currentNum)){
                memo.put(currentNum,1);
            }
            else{
                memo.put(currentNum,memo.get(currentNum)+1);
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int currentNum:nums2){
            if(memo.containsKey(currentNum)){
                answer.add(currentNum);
                memo.put(currentNum,memo.get(currentNum)-1);
             
                if(memo.get(currentNum)==0){
                    memo.remove(currentNum);
                }
            }
        }
               
               int result[] = new int[answer.size()];
               for(int i=0;i<answer.size();i++){
                   result[i] = answer.get(i);
               }
               return result;
        
    }
}
