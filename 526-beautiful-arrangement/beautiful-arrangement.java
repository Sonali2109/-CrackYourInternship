class Solution {
    public static int count;

    public int countArrangement(int n) {
        count = 0;
        int[] perm = new int[n+1];
        backtrack(perm, 1);

        return count;
    }

    public void backtrack(int[] perm, int pos) {
        if(pos == perm.length)
        {
            count++;

            return;
        }

        for(int i = 1; i < perm.length; i++)
        {
            if(perm[i] == 0 && (i%pos == 0 || pos%i == 0))
            {
                perm[i] = pos;
                backtrack(perm, pos+1);
                perm[i] = 0;
            }
        }
    }
}