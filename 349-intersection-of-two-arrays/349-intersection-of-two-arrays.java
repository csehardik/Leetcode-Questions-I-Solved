class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Boolean> memo = new HashMap<Integer,Boolean>();
        
        for(int currentNum:nums1){
            if(!memo.containsKey(currentNum))
                memo.put(currentNum,true);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int currentNum:nums2){
        if(memo.containsKey(currentNum)&& memo.get(currentNum))  // this condition says that check whetehr the map contains this value and also check if it has the value as false
            { 
                answer.add(currentNum); // if the above conditions says the value is not present already in the map so we add that value in the map and then marks it false
                memo.put(currentNum,false);
            }
                
        }
        
        int result[] = new int[answer.size()];
        for(int i=0; i<answer.size();i++){
            result[i]=answer.get(i);
            
        }
            return result;
    
}
}