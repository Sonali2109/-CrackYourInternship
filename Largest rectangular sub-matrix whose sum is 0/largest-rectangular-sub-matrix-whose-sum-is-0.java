class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int target = 0;
        int n = mat.length;
        int m = mat[0].length;
        int maxArea = 0, startRow = 0, endRow = -1, startCol = 0, endCol = -1;
        int[][] sum = new int[n][m];
         for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                sum[i][j] = mat[i][j] + (j > 0 ? sum[i][j-1] : 0) ;
            }
        }
        for(int strt_col = 0; strt_col < m; strt_col++){
            for(int end_col = strt_col; end_col < m; end_col++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,-1);
                int cumSum = 0;
                for(int row = 0; row < n; row++){
                    int prev = strt_col > 0 ? sum[row][strt_col - 1] : 0;
                    cumSum += sum[row][end_col] - prev;
                    int key = cumSum - target;
                    if(map.containsKey(key)){
                        int area = (end_col - strt_col + 1) * (row - map.get(key));
                        if(area > maxArea){
                            maxArea = area;
                            startRow = map.get(key) + 1;
                            endRow = row;
                            startCol = strt_col;
                            endCol = end_col;
                        }
                    }else{
                        map.put(cumSum,row);
                    }
                    
                }
            }
        }
        if(maxArea == 0) return result;
        for(int i = startRow; i <= endRow; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = startCol; j<= endCol; j++){
                list.add(mat[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
