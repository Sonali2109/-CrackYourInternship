// User function Template for Java

class Solution {
    private static final int[][] keyPad = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}, 
        {-1, 0, -1}
    };
    
    private static final int[] dirX = {0, 0, 1, -1};
    private static final int[] dirY = {1, -1, 0, 0};
    
    public long getCount(int N) {
        if (N == 1) return 10;
        
        long[] dpPrevious = new long[10];
        long[] dpCurrent = new long[10];
        
        for (int i = 0; i < 10; i++) {
            dpPrevious[i] = 1;
        }
        
        for (int length = 2; length <= N; length++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keyPad[i][j] != -1) {
                        int key = keyPad[i][j];
                        dpCurrent[key] = dpPrevious[key];
                        
                        for (int k = 0; k < 4; k++) {
                            int newI = i + dirX[k];
                            int newJ = j + dirY[k];
                            
                            if (newI >= 0 && newJ >= 0 && newI < 4 && newJ < 3 && keyPad[newI][newJ] != -1) {
                                dpCurrent[key] += dpPrevious[keyPad[newI][newJ]];
                            }
                        }
                    }
                }
            }
            long[] temp = dpPrevious;
            dpPrevious = dpCurrent;
            dpCurrent = temp;
        }
        
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dpPrevious[i];
        }
        
        return ans;
    }
}
