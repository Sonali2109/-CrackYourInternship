class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        backtrack(1, n, visited);
        return count;
    }

    public void backtrack(int pos, int n, boolean[] visited) {
        if (pos == n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!visited[i-1]) {
                if (i % (pos + 1) == 0 || (pos + 1) % i == 0) {
                    visited[i-1] = true;
                    backtrack(pos+1, n, visited);
                    visited[i-1] = false;
                }
            }
        }
    }
}