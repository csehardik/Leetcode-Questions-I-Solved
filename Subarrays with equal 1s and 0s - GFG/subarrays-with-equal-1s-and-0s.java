//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        HashMap<Integer,Integer>memo = new HashMap<Integer,Integer>();
        
        int prefixSum=0;
        int answer = 0;
        
        memo.put(prefixSum,1);
        
        for(int i = 0;i<n;i++){
            // prefixSum+=arr[i];
            
             if(arr[i]==0)// we are checking that wherever we encounter 0 as an entry in my arr array ,
                prefixSum += -1;// I will replace that 0 with -1
            
            else 
                prefixSum += 1;
            
            if(memo.containsKey(prefixSum)){
                answer+=memo.get(prefixSum);
            memo.put(prefixSum,memo.get(prefixSum)+1);
            }else{
                memo.put(prefixSum,1);
            }
        }
        return answer;
    }
}


