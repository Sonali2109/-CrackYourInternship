class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean canColor(int node, int[] col,List<List<Integer>> adj, int color ){
        for(int i : adj.get(node)){
            if(col[i] == color) return false;
        }  
        return true;
    }
    public boolean isPossible( int node, List<List<Integer>> adj, int m, int n, int[] col){
        if(node == n) return true;

        for(int j = 0; j < m; j++){
            if(canColor(node, col, adj, j)) {
                col[node] = j;
                
                if(isPossible(node + 1, adj, m, n, col))
                    return true;
                else col[node] = -1;
            }
        }
        return false;
    }
        
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == true){
                    adj.get(i).add(j);
                }
            }
            
        }
        int[] col = new int[n];
        Arrays.fill(col, -1);
        return isPossible(0, adj, m, n, col);
        
    }
}
