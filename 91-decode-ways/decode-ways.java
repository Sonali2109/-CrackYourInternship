class Solution {
    public int numDecodings(String s) 
    {
        int n = s.length();
        int[] res = new int[n+1];

        res[0] = 1;
        res[1] = s.charAt(0) == '0' ? 0 :1;

        for(int i=2; i<=n; i++)
        {
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));

            if(oneDigit>=1)
            {
                res[i] = res[i] + res[i-1];

            }

            if(twoDigit>=10 && twoDigit<=26)
            {
                 res[i] = res[i] + res[i-2];
            }
        }
        return res[n];   
    }
}