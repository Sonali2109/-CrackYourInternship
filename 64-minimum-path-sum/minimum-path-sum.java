class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        return func(grid,n-1,m-1,dp);
    }
    public int func(int[][] arr,int i,int j,int[][] dp){
        if(i < 0 || j < 0)return (int)Math.pow(10,9);
        if(i == 0 && j == 0){
            return arr[i][j];
        }

        if(dp[i][j] != 0)return dp[i][j];

        int l = arr[i][j] + func(arr,i,j-1,dp);
        int u = arr[i][j] + func(arr,i-1,j,dp);

        return dp[i][j] = Math.min(l,u);
    }
}