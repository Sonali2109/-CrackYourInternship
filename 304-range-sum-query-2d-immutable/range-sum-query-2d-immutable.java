class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        for(int i=1;i<n;i++) matrix[i][0]+=matrix[i-1][0];
        for(int i=1;i<m;i++) matrix[0][i]+=matrix[0][i-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j]+=(matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1]);
            }
        }
        mat=matrix;
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int ans=mat[r2][c2];
        if(r1>0) ans-=mat[r1-1][c2];
        if(c1>0) ans-=mat[r2][c1-1];
        if(r1>0 && c1>0) ans+=mat[r1-1][c1-1];
        return ans;
    }
}