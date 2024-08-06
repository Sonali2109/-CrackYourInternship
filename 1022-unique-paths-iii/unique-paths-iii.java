class Solution {
    int nonObs=1,res;
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    void backtracking(int[][] grid, int i,int j,int count){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1) return;

        if(grid[i][j]==2){
            if(count==nonObs) res++;
            return;
        }
        grid[i][j]=-1;
        for(int[] dir:dirs){
            int i_=i+dir[0]; int j_=j+dir[1];
            backtracking(grid,i_,j_,count+1);
        }
        grid[i][j]=0;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int x=0, y=0; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) nonObs++;
                else if(grid[i][j]==1){
                    x=i;y=j;
                }
            }
        }    
        int count=0;  
         backtracking(grid,x,y,count);
         return res;
    }
}