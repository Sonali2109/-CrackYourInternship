class Solution {
    public String shortestPalindrome(String s) 
    {
        int m=s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        String rev=sb.toString();

        String combined_str=s+'#'+rev;
        int n=combined_str.length();

        int[] lps = new int[n];
        int i=0,j=1;
        lps[0]=0;

        while(j<combined_str.length()){
            if(combined_str.charAt(i)==combined_str.charAt(j))
            {
                lps[j]=i+1;
                i++;
                j++;
            }
            else if(i!=0){
                i=lps[i-1];
            }
            else{
                lps[j]=0;
                j++;
            }
        }
        return rev.substring(0,m-lps[n-1])+s;
    }
}