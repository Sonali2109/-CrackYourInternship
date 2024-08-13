class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        // To Store maximum value between the range
        Map<Pair<Integer, Integer>, Integer> max = new HashMap<>();
        for(int i = 0; i < n; i++){
            max.put(new Pair(i,i), arr[i]);
            for(int j = i + 1; j < n; j++){
                max.put(new Pair(i, j), Math.max(arr[j], max.get(new Pair(i, j - 1))));
            }
        }

        // return helper(arr, max, 0, n - 1);
        
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(arr, max, 0, n - 1, dp);
    }

    public int helper(int[] arr, Map<Pair<Integer, Integer>, Integer> max, int left, int right){
        if(left == right) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i = left; i < right; i++){
            ans = Math.min(ans, 
                max.get(new Pair(left, i)) * max.get(new Pair(i + 1, right)) 
                + helper(arr, max, left, i) + helper(arr, max, i + 1, right)
                );
        }
        return ans;
    }

    public int helperMem(int[] arr, Map<Pair<Integer, Integer>, Integer> max, int left, int right, int[][] dp){
        if(left == right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int ans = Integer.MAX_VALUE;

        for(int i = left; i < right; i++){
            ans = Math.min(ans, 
                max.get(new Pair(left, i)) * max.get(new Pair(i + 1, right)) 
                + helperMem(arr, max, left, i, dp) + helperMem(arr, max, i + 1, right, dp)
                );
        }
        return dp[left][right] = ans;
    }
}