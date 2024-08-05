class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        
        if(row == 9)    return true;
        if(col == 9)    return solveSudoku(board, row+1, 0);

        if(board[row][col] != '.')
            return solveSudoku(board, row, col+1);
        
        for(char i='1'; i<='9'; i++)
        {
            if(isSafeSudoku(board, row, col, i))
            {
                board[row][col] = i;
                if(solveSudoku(board,row,col+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isSafeSudoku(char[][] a, int row, int col, int num)
    {
        for(int i=0; i<9; i++)
        {
            if(a[row][i] == num)
                return false;
            
            if(a[i][col] == num)
                return false;
        }

        int gridRow = row/3;
        int gridCol = col/3;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                int cellRow = 3 * gridRow + i;
                int cellCol = 3 * gridCol + j;

                if(a[cellRow][cellCol] == num)
                    return false;
            }
        }

        return true;
    }
}