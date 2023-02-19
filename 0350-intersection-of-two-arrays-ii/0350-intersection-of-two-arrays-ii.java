class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        

        
        //initialize new hashmap
        HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
        
        //iterate over nums1 
        for(int currentNum : nums1)
        {
            //check if hashmap does not contains the element
            if(!memo.containsKey(currentNum))
            {
                //if doesn't contains the element create an entry and mark value as true
                memo.put(currentNum,1);
            }
            else{
                memo.put(currentNum,memo.get(currentNum)+1);
            }
        }

        //create an answer arraylist of integer type
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        //iterate over nums2
        for(int currentNum : nums2)
        {

            //check if hashmap contains the element from nums2 already and is the value of that entry is true 
            if(memo.containsKey(currentNum))
            {
                //if entry is true then add that elemet to the answer list and mark the entry in hashmap as false for that element key
                answer.add(currentNum);
                memo.put(currentNum,memo.get(currentNum)-1);
            
            if(memo.get(currentNum)==0){
                memo.remove(currentNum);
            }

        }
        }

        //create a new earray resut of size equal to answer list size
        int result[] = new int[answer.size()];
        
        //put all the elements of answer list in the result array
        for(int i=0;i<answer.size();i++)
        {
            result[i]=answer.get(i);
        }
        return result;
    }
}