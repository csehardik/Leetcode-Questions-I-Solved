// In this array we need to check that is it possible to divide the array in pairs in the way that the pairs are divisible by k.

class Solution {
    public boolean canArrange(int[] arr, int k) {
        
int memo[] = new int[k]; // initial the array of size k (i.e k is the number by which pair should be divisible)(AND THIS ARRAY IN STARTING HAVE 0 VALUE IN EACH INDEX OF ARRAY)
        
        for(int currentVal:arr){
            
            int currentRemainder = ((currentVal % k) + k) %k; // this line makes the  remainder we get on dividing -ve number as correct and non -ve (as remainder can't be -ve) 
            memo[currentRemainder] += 1; // whenever we encountered a number not having a entry alreadfy in the array increase  the frequency from zero to one . 
            
        }
        
        for(int i=0;i<=k/2;i++){ // we go till k/2 only because no need to match or create pair of two numbers again (for eg (1,4) so we need not ot check for(4,1))
            
            if(i==0){ // in this we are checking that for 0th index the count should always be even
                
                if(memo[i]%2 !=0)//checking count for oth index is even or not
                return false;//return false if frequency at zero index not even .
            
            }else{
                
                int y = k-i; // y is for finding the 
                
                if(memo[i] != memo[y])
                    return false;
            }
        }
        
        return true;
        
    }
}