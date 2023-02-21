//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        ArrayList<Integer> answer = new ArrayList<>(); //initialise an arraylist of name ANSWER 
        HashMap<Integer,Integer> memo = new HashMap<>(); //initialise a HASHMAP
        int distinct = 0; // initialise a variable DISTINCT = 0;//will help us to find count of distinct elements in every window of size k
        
        for(int i=0;i<k;i++)//for acquiring k elements in the 1st window and we will go till k because indexes are 0 based
        {
            int currentVal = A[i]; //to check what is the value of current element//we will store the current element in the currentVal
            
            if(memo.containsKey(currentVal))//to check whether currentvalue already present in our hashmap or not
            {
                memo.put(currentVal,memo.get(currentVal)+1);//if already present in our hashmap then,we will increment the frequency/value by 1
            }
            else
            { //if currentval element not present already in hashmap
                memo.put(currentVal,1);//create an entry of that element in hashmap with value = 1
                distinct += 1;//we will also increment the value of distinct variable
            }
        }
        
        answer.add(distinct);//as we have stored k element in our hashmap so now, we will add the value of distinct variable in the answer array
        int release = 0;//initialise a release pointer with value 0
        
        for(int acquire=k;acquire<n;acquire++)//we will again start acquiring , now acquiring will start from k index element 
        {//as we cannot acquire new element in a window having size k without releasing the element
            int discardElement = A[release];//we will release/delete/discard the value present at 0th index (as release pointer currently points at 0th index) from our current window)   
            memo.put(discardElement,memo.get(discardElement)-1);//we will now , decrement the frequency of that element at the 0th index by 1
            release += 1;//increment the release pointer i.e now release pointer points to the 1st index element
            
            if(memo.get(discardElement)==0)//if value of frequency of our discard element becomes 0 
            {
                memo.remove(discardElement);//delete the element from our hashmap
                distinct -= 1;//decrement the count/value of distinct variable
            }
            
            int currentVal = A[acquire];// as we have released an element then we can acquire the new element now
            
            if(memo.containsKey(currentVal))//if hashmap already contains  the currentval element
            {//then
                memo.put(currentVal,memo.get(currentVal)+1);//increment by 1 the frequency/value of that element key 
            }
            else
            {//if element of currentval not already present in the hashmap 
                memo.put(currentVal,1);//create a new entry of that element having value = 1
                distinct += 1;//increment the value of DISTINCT variable
            }
            answer.add(distinct);//as we have stored k element in our hashmap so now, we will add the value of distinct variable in the answer array 
            
        }
         return answer;// return the final answer
    }
}

