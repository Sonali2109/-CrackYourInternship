class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        int min = 0;
        int n = grid.length; //row
        int m = grid[0].length;  //col

        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 2)
                    dfs(i,j,grid,-1);
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] !=1){
                    min = Math.min(min,grid[i][j]);
                }else{
                    return -1;
                }
            }
        }
        return min == 0?0:-min-1;
    }

    public static void dfs(int i , int j , int[][]grid,int min)
    {
        grid[i][j] = min;
        min--;
        if(i>0 && (grid[i-1][j] == 1 || grid[i-1][j] <min)){
            dfs(i-1,j,grid,min);
        }
        if(j>0 && (grid[i][j-1] == 1 || grid[i][j-1] <min)){
            dfs(i,j-1,grid,min);
        }
        if(i<grid.length-1 && (grid[i+1][j] == 1 || grid[i+1][j] <min)){
            dfs(i+1,j,grid,min);
        }
        if(j<grid[0].length-1 && (grid[i][j+1] == 1 || grid[i][j+1] <min)){
            dfs(i,j+1,grid,min);
        }
        

    }
}