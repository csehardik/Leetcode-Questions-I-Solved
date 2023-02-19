//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


//Approach we Used :

// in this hashMap has entry like [key = prefixSum & value = currentIndex]

// if we have two points A & B having n points placed and having sum = S 
// then we have two points A & C and having point B placed in b/w A & C , B/w A & B there are m points placed  having sum = S
// so , that means we have sum = 0 B/W points B & C 
// Sum(AC) = Sum(AB) + Sum(BC) => [ S = S + Sum(BC) ]=> [ Sum(BC) = 0 ]


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer>memo= new HashMap<Integer,Integer>();//initialise a new empty hashMap of Integer type key : value pair
        int answer=0;
        int prefixSum=0;
        
        memo.put(prefixSum,-1); // In the hashMap place value = -1 for key = 0
        
        for(int i=0; i<n;i++){
            prefixSum+=arr[i]; // As we traverse through the array add each number we encounter ,  in the prefixSum (i.e 0) 
            
        if(memo.containsKey(prefixSum)) // check whether the value we get after adding in the prefixSum is already present in hashMap or not.
        answer = Math.max(answer,i-memo.get(prefixSum));// if we get the value of prefixSum already present before in the hashMap , 
                                                       // we replace the value of answer from 0 to max of (answer , longest subarray 
                                                      // having sum zero(0) , here i - memo.get (prefixSum) means , currentIndex having 
                                                     // prefixSum already encountered - index on which the encountered value was firstly stored/present)
        
        else
        memo.put(prefixSum,i);// if our memo encounters a new prefixSum value that's not matching any stored value of hashMap then , we will store value of
                             //prefixSum having currentIndex value i
        
        }
        
        return answer;
    }
}