class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                visited[i][j] = true;
                if(board[i][j] == word.charAt(0) && backtrack(0, i, j, board, word, visited))
                    return true;
                visited[i][j] = false;
            }
        }

        return false;
    }

    private boolean backtrack(int curr, int i, int j, char[][] board, String word, boolean[][] visited)
    {
        if(curr == word.length()-1) return true;

        //traversing in top direction
        if(i-1>=0 && board[i-1][j] == word.charAt(curr+1) && !visited[i-1][j])
        {
            visited[i-1][j] = true;
            boolean ans = backtrack(curr+1, i-1, j, board, word, visited);
            if(ans) return true;
            visited[i-1][j] = false;
        }

        //traversing in left direction
        if(j-1>=0 && board[i][j-1] == word.charAt(curr+1) && !visited[i][j-1])
        {
            visited[i][j-1] = true;
            boolean ans = backtrack(curr+1, i, j-1, board, word, visited);
            if(ans) return true;
            visited[i][j-1] = false;
        }

        //traversing in bottom direction
        if(i+1<board.length && board[i+1][j] == word.charAt(curr+1) && !visited[i+1][j])
        {
            visited[i+1][j] = true;
            boolean ans = backtrack(curr+1, i+1, j, board, word, visited);
            if(ans) return true;
            visited[i+1][j] = false;
        }

        //traversing in right direction
        if(j+1<board[0].length && board[i][j+1] == word.charAt(curr+1) && !visited[i][j+1])
        {
            visited[i][j+1] = true;
            boolean ans = backtrack(curr+1, i, j+1, board, word, visited);
            if(ans) return true;
            visited[i][j+1] = false;
        }

        return false;
    }
    
}