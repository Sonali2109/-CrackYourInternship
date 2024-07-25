class Solution {
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;

        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str, int l, int r)
    {
        while(l<=r)
        {
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}