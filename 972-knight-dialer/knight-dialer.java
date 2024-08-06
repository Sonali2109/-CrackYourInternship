class Solution {
    public int knightDialer(int n) {
        int dialerComb[][][] = new int[n][4][3], mod = 1000000007;
        for(int r = 0; r < 4; r++){
            Arrays.fill(dialerComb[0][r], 1);
        }
        for(int movNo = 0; movNo < n; movNo++){
            dialerComb[movNo][3][0] = dialerComb[movNo][3][2] = -1;
        }
        int dirs[][] = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for(int movNo = 1; movNo < n; movNo++){
            for(int r = 0; r < 4; r++){
                for(int c = 0; c < 3; c++){
                    if (dialerComb[movNo][r][c] == -1)continue;
                    for(var dir : dirs){
                        int prevRow = r + dir[0], prevCol = c + dir[1];
                        if(isSafe(dialerComb, prevRow, prevCol, movNo-1)){
                             dialerComb[movNo][r][c] = (dialerComb[movNo][r][c] % mod +  dialerComb[movNo-1][prevRow][prevCol] % mod)%mod;
                        }
                    }
                }
            }
        }

        int unqPhnNum = 0;
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 3; c++){
                 if(dialerComb[n-1][r][c] == -1)continue;
                 unqPhnNum =  (unqPhnNum % mod + dialerComb[n-1][r][c] % mod)%mod;
            }
        }
        return unqPhnNum;
    }
    private boolean isSafe(int [][][]dialerComb, int prevRow, int prevCol, int movNo){
        return movNo  > -1 && prevRow < 4 && prevCol < 3  && prevRow > -1 && prevCol > -1 && dialerComb[movNo][prevRow][prevCol] != -1;
    }    
}