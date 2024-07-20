class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        java.util.Collections.sort(a);
        long min = Integer.MAX_VALUE;
        
        for(int i=0; i+m-1 < a.size(); i++)
        {
            long diff = a.get(i+m-1) - a.get(i);
            if(diff < min)  min = diff;
        }
        
        return min;
    }
}
