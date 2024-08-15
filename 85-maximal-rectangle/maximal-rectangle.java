class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxRectangle = 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[] heights = new int[col];

        // 연속된 '1'들이 나타날 수 있는 가장 왼쪽 위치 저장
        int[] leftBoundaries = new int[col];
        
        // 연속된 '1'들이 끝나는 가장 오른쪽 위치 저장
        int[] rightBoundaries = new int[col];
        Arrays.fill(rightBoundaries, col);

        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col;

            // 가장 왼쪽 위치 세팅
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++; // '1'인 경우 높이 증가
                    leftBoundaries[j] = Math.max(leftBoundaries[j], left);
                } else {
                    heights[j] = 0;
                    leftBoundaries[j] = 0;
                    // '1'의 왼쪽 위치를 현재 위치의 다음으로 설정
                    // 왜냐하면 현재 위치는 아니라는 뜻이니까
                    left = j + 1;
                }
            }

            // 가장 오른쪽 위치 세팅
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rightBoundaries[j] = Math.min(rightBoundaries[j], right);
                } else {
                    rightBoundaries[j] = col;
                    
                    // '1'의 끝나는 점을 현재 위치로 설정
                    right = j;
                }
            }

            // 각 열에 대해 가능한 최대 직사각형의 면적 계산
            for (int j = 0; j < col; j++) {
                int width = rightBoundaries[j] - leftBoundaries[j]; // 너비

                int area = heights[j] * width; // 면적

                maxRectangle = Math.max(maxRectangle, area);
            }
        }

        return maxRectangle;  // 계산된 최대 직사각형 면적 반환
    }
}