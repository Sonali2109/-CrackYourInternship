class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int n = s.length();
        for(int i = 0 ; i < n ; i++)
        {
            count[s.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        int indexOfMax = 0;
        for(int i = 0 ; i < count.length ; i++)
        {
            if(maxCount < count[i])
            {
                maxCount = count[i];
                indexOfMax = i;
            }
        }
        if(maxCount > (n+1)/2)
        return "";
        char[] ans = new char[n];
        int index = 0;
        while(count[indexOfMax] != 0)
        {
            ans[index] = (char) (indexOfMax + 'a');
            index = index + 2;
            count[indexOfMax]--;
        }
        for(int i = 0 ; i < count.length ; i++)
        {
            while(count[i] != 0)
            {
                if(index >= ans.length)
                index = 1;
            
            ans[index] = (char)(i + 'a');
            index = index + 2;
            count[i]--;
            }
        }
        return String.valueOf(ans);

    }
}