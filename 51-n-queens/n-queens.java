class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(board[i],'.');
        int[] row=new int[n];
        int[] ud=new int[(2*n)-1];
        int[] ld=new int[(2*n)-1];
        generate(res,board,0,n,row,ud,ld);
        return res;
    }
    void generate(List<List<String>> res,char[][] board,int ind,int n,int[]row,int[] ud,int[] ld)
    {
        if(ind==n)
        {
            List<String> lo=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                lo.add(new String(board[i]));
            }
            res.add(lo);
        }
        for(int i=0;i<n;i++)
        {
            if(row[i]!=1 && ud[(n-1)+(ind-i)]!=1 && ld[i+ind]!=1 )
            {
                row[i]=1;
                ud[n-1+ind-i]=1;
                ld[i+ind]=1;
                board[i][ind]='Q';
                generate(res,board,ind+1,n,row,ud,ld);
                board[i][ind]='.';
                row[i]=0;
                ud[n-1+ind-i]=0;
                ld[i+ind]=0;
            }
        }
    }
}