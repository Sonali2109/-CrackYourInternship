class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.isEmpty()) return 0;
        
        int n = haystack.length();
        int m = needle.length();

        if(n < m)   return -1;
        
        for(int i=0; i<=n-m; i++)
        {
            int j=0;

            while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }

            if(j == needle.length())    return i;
        }

        return -1;
    }
}