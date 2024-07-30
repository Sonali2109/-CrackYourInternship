class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length()-1, sSkip = 0, tSkip = 0;

        while(i >= 0 || j >= 0)
        {
            while(i>=0 && (s.charAt(i)=='#' || sSkip > 0)){
                if(s.charAt(i) == '#'){
                    sSkip++;
                    i--;
                }  
                else{
                    sSkip--;
                    i--;
                }
            }

            while(j>=0 && (t.charAt(j)=='#' || tSkip > 0)){
                if(t.charAt(j) == '#'){
                    tSkip++;
                    j--;
                }  
                else{
                    tSkip--;
                    j--;
                }
            }

            if(j<0 && i>=0) return false;
            if(i<0 && j>=0) return false;
            if(j>=0 && i>=0 && s.charAt(i) != t.charAt(j))  return false;

            i--;
            j--;
        }

        return true;
    }
}