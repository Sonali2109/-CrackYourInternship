class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if(p == "" || p.length()>s.length())    return "-1";
        
        if(s.equals(p)) return s;
        
        Map<Character, Integer> pat = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<p.length(); i++) pat.put(p.charAt(i), pat.getOrDefault(p.charAt(i),0)+1);
        
        int curlen = 0;
        int totallen = pat.size();
        String res = "-1";
        int reslen = Integer.MAX_VALUE;
        
        int l=0, r=0;
        
        while(r < s.length())
        {
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(pat.containsKey(c) && pat.get(c) == map.get(c))  
                curlen += 1;
                
            while(curlen == totallen)
            {
                if((r-l+1)<reslen)
                {
                    res = s.substring(l,r+1);
                    reslen = r-l+1;
                }
                
                char t = s.charAt(l);
                map.put(t,map.get(t)-1);
                
                if(pat.containsKey(t) && map.get(t) < pat.get(t)){
                    curlen -= 1;
                }
                
                l+=1;
            }
            
            r++;
        }
        
        return (reslen != Integer.MAX_VALUE)? res : "-1";
    }
}
