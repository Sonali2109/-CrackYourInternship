class Solution {
   // int m, n;
    public int kthSmallest(int[][] matrix, int k) {
      int r = matrix.length;
      int  c = matrix[0].length; 
        int min = matrix[0][0], max = matrix[r-1][c-1], ans = -1;
        while (min<=max) {
            int mid = (min+max)/2;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                max = mid - 1;
            } 
            else 
            {min= mid + 1;}
        }
     return ans;
    }

    int countLessOrEqual(int[][] matrix, int x) {
          int r = matrix.length;
          int  c = matrix[0].length; 
        int count = 0, column = c - 1; 
        for (int i = 0; i<r;i++) {
            while (column >= 0 && matrix[i][column] > x) {
                column--;
            }  // decrease column until matrix[r][c] <= x
            count += (column + 1);
        }
        return count;
    }
}