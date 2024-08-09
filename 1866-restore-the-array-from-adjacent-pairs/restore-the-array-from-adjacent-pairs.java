class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(var prs : adjacentPairs){
            int u = prs[0], v = prs[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer> visitedVert = new HashSet<>();
        Deque<Integer> que = new ArrayDeque<>();
        que.offerLast(adjacentPairs[0][0]);
        int lastVertVist = -1;
        while(!que.isEmpty()){
            var currVert = que.pollFirst();
            lastVertVist = currVert;
            visitedVert.add(currVert);
            for(var neigh : graph.get(currVert)){
              if(!visitedVert.contains(neigh))  
                que.offerLast(neigh);
            }
        }
        visitedVert.clear();
        List<Integer> orgArr = new ArrayList<>();
        buildArray(lastVertVist, graph, orgArr, visitedVert);
        return orgArr.stream().mapToInt(x->x).toArray();
    }
    
    private void buildArray(int src, Map<Integer, List<Integer>> graph, List<Integer> orgArr, HashSet<Integer> visitedVert){
        if(visitedVert.contains(src)){
            return;
        }
        visitedVert.add(src);
        orgArr.add(src);
        for(var neigh : graph.get(src)){
            if(!visitedVert.contains(neigh))
              buildArray(neigh, graph, orgArr, visitedVert);
        }

    }
}