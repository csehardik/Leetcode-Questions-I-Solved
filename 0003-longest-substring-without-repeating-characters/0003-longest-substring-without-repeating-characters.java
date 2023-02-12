class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //initialise answer variable = 0;
      int answer = 0;
        
        //initialise a hashMap of charcater type key & Integer type value 
        //key stores character(key:character) & value stores count of occurenece of that character(value:character)
      HashMap<Character,Integer> memo = new HashMap<Character,Integer>();
        
        //initialise a release variable
      int release=0;
        
        
        //use FOR loop to iterate over the i/p string and take character you get one by one and using this FOR loop we firstly releade and than acquire the character
        for(int acquire=0;acquire<s.length();acquire++)
        {
            //store the character you encounter in the currencChar character
            Character currentChar = s.charAt(acquire);
            
            //use while loop to release and check if hashamap has a entry in the hashmap
            while(release<acquire && memo.containsKey(currentChar))
            {
                //store the character to discard in the discardChar character
                Character discardChar = s.charAt(release);
                
                //delete the discardElement character
                memo.remove(discardChar);
                //increase the release pointer by 1
                release+=1;
                
            }
            
            //if the hashmap doesn't have the entry for the character we encountered than create a new entry and place the index number in value field on which the particular element lies in the i/p string
            memo.put(currentChar,acquire);
            //in the answer variable store the maximum of answer and acquire-release+1;
            answer = Math.max(answer,acquire-release+1);
            
        }
        
        //return answer
        return answer;
        
    }
}