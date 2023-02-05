class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        //initialize new hashmap
        HashMap<Integer,Boolean> memo = new HashMap<Integer,Boolean>();
        
        //iterate over nums1 
        for(int currentNum : nums1)
        {
            //check if hashmap does not contains the element
            if(!memo.containsKey(currentNum))
            {
                //if doesn't contains the element create an entry and mark value as true
                memo.put(currentNum,true);
            }
        }

        //create an answer arraylist of integer type
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        //iterate over nums2
        for(int currentNum : nums2)
        {

            //check if hashmap contains the element from nums2 already and is the value of that entry is true 
            if(memo.containsKey(currentNum) && memo.get(currentNum))
            {
                //if entry is true then add that elemet to the answer list and mark the entry in hashmap as false for that element key
                answer.add(currentNum);
                memo.put(currentNum,false);
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