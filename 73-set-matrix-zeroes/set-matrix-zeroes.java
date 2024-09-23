class Solution {
    public void setZeroes(int[][] matrix) 
    {
        int n = matrix.length; 
        int m = matrix[0].length; 
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Step 1: Traverse the matrix and mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the i-th row and j-th column
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Set matrix cells to 0 if their row or column is marked
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }   
    }
}