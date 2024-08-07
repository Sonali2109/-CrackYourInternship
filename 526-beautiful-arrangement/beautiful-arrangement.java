class Solution {

    private int count = 0;

    private void calculate(int n, int pos, boolean[] visited)
    {
        if(pos>n)  count++;

        for(int i=1; i<=n; i++)
        {
            if(!visited[i] && (pos % i == 0 || i % pos == 0))
            {
                visited[i] = true;
                calculate(n, pos+1, visited);
                visited[i] = false; //backtrack if no suitable condition is true !
            } 
        }
    }

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        calculate(n,1,visited);
        return count;
    }
}