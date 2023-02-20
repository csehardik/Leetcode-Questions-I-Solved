        // In this array we need to check that is it possible to divide the array in pairs in the way that the pairs are divisible by k.

// Imp Points : 
// 1.remainder cannot be -ve (most important point to keep in mind)
// 2.i/p array can also contain -ve number
// 3. FORMULA TO FIND REMAINDER OF NEGATIVE NUMBERS = (((a%b)+b)%b)
// 4. (a+b)%k = ((a%k)+(b%k))%k => [x+(b%k)]%k => [x+(k-x)]%k => k%k (i.e AS REMAINDER OF (a%k = X) , so what reaminder should (b%k) give so that both a nd b can make a pair)
// 5.The number we get by doing k-currentIndex/x(remainder of first number whose pair to be found) we are on should have the same frequency as the number having remainder x
// 6. we have (a,b) and k , so if a gives remainder x when divided by k . so b will have have remainder as k-x (eg. =  to get (a+b)%k = k , let a  has raminder 1 and k=5 so b will have raminder 4 as  to get (1+4)%5 = 5)
//7. In this key = remainder & value = count of numbers having that same remainder 
// 8. dividend = (divisor * quotient + remainder)


class Solution {
    public boolean canArrange(int[] arr, int k) {
        
int memo[] = new int[k]; // initial the array of size k (i.e k is the number by which pair should be divisible)(AND THIS ARRAY IN STARTING HAVE 0 VALUE IN EACH INDEX OF ARRAY)
        
        for(int currentVal:arr){
            
            int currentRemainder = ((currentVal % k) + k) %k; // this line makes the  remainder we get on dividing -ve number as correct and non -ve (as remainder can't be -ve) 
            memo[currentRemainder] += 1; // whenever we encountered a number not having a entry alreadfy in the array increase  the frequency from zero to one . 
            
        }
        
        for(int i=0;i<=k/2;i++){ // we go till k/2 only because no need to match or create pair of two numbers again (for eg (1,4) so we need not ot check for(4,1))
            
            if(i==0){ // in this we are checking that for 0th index the count should always be even
                
                if(memo[i]%2 !=0)   //checking count for oth index is even or not. we need to check this because if we have k=5 and first element of array as 5 so 5%k i.e 5%5 =                                       0(zero) . so b should have remainder k-a%k i.e 5-0=5 and that's not possible because we don't have index 5 in the array.
                    
                return false;   //return false if frequency at zero index not even .
            
            }else{
                
                int y = k-i; // y is for finding b as to make the pair(a,b) which is divisble by k.
                             // here y = k - remainder we get on dividing a by k(a%k) .                              
                
                if(memo[i] != memo[y])// if remainder of a != remainder of b (i.e k-remainder of a) (for eg if we have k = 7 and we have a's remainder as 1 so b should have                                              reaminder 6 to make 1+6 = 7%7(k) = 0 making it divisible by k )
                    return false;
            }
        }
        
        return true;
        
    }
}
