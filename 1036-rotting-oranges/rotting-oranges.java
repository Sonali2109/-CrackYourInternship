import java.util.*;
class orange{
    int row,col,mins;
    public orange(int r,int c,int m){
        this.row = r;
        this.col = c;
        this.mins= m;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
         int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        Queue<orange> queue = new ArrayDeque<>();
        for(int i= 0;i <r;i++){
            for(int j=0;j<c;j++){
               if(grid[i][j] == 1){
                   fresh++;
                   
               } 
               else if(grid[i][j] == 2){
                   queue.add(new orange(i,j,0));
                   grid[i][j] = 0;
               }
            }
        }
        if(queue.isEmpty() && fresh == 0){
            return 0;
        }
        int maxMins = 0;
        int rowdiff[] = {-1,0,0,1};
        int coldiff[] = {0,-1,1,0};
        
        while(!queue.isEmpty()){
            orange curr = queue.poll();
            maxMins = Math.max(maxMins,curr.mins);
            for(int i=0;i<4;i++){
                int adjr = curr.row+rowdiff[i];
                int adjc = curr.col+coldiff[i];
                if(adjr >= 0 && adjr<r && adjc>=0 && adjc<c && grid[adjr][adjc] == 1){
                queue.add(new orange(adjr,adjc,curr.mins+1));
                    
                    fresh--;
                grid[adjr][adjc] = 0;
                } 
            }
        }
        if(fresh>0){
            return -1;
        }
        return maxMins;
        }
}