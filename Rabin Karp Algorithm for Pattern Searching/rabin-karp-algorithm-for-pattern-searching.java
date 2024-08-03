//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        int x=pattern.length();
        int y=text.length();
        ArrayList<Integer> arr= new ArrayList<>();
        if(text.length()<pattern.length()) return arr;
        
        for(int i=0;i<y-x+1; i++){
            String str=text.substring(i,i+x);
            if(pattern.equals(str)) arr.add(i+1);
        }
        
        return arr;
    }
}
