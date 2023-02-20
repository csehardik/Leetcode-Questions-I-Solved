//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends


class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int n)
    {
        
        // we will change this problem's statement from finding largest subarray of 0's and 1's to
        // Finding Length Of Longest Subarray Having Equal Number Of 1's And -1's
        
        HashMap<Integer,Integer>memo= new HashMap<Integer,Integer>();
        int answer=0;
        int prefixSum=0;
        
        memo.put(prefixSum,-1);
        
        for(int i=0; i<n;i++){
            
            // prefixSum+=arr[i];
            
            if(arr[i]==0)// we are checking that wherever we encounter 0 as an entry in my arr array ,
                prefixSum += -1;// I will replace that 0 with -1
            
            else // otherwise 
                prefixSum += 1;// I will add that 1 itself 
            
        if(memo.containsKey(prefixSum))
        answer = Math.max(answer,i-memo.get(prefixSum));
        else
        memo.put(prefixSum,i);
        }
        return answer;
        
    }
}

