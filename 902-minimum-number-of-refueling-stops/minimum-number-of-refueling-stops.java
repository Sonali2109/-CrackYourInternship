class Solution {
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return b - a;
        });
        
        int maxReach = startFuel;
        int count = 0;
        
        for(int i = 0; i < stations.length; i++){
            int st = stations[i][0];
            int f = stations[i][1]; 
            if(maxReach < st){
                while(!pq.isEmpty() && maxReach < st){
                    maxReach += pq.poll();
                    count++;
                }
                
                if(maxReach >= target){
                    return count;
                }
                if(maxReach < st){
                    return -1;
                }
            }
            pq.add(f);
        }
        
        if(maxReach < target){
            while(!pq.isEmpty() && maxReach < target){
                maxReach += pq.poll();
                count++;
            }
        }
        
        if(maxReach >= target){
            return count;
        }
        else{
            return -1;
        }
    }
}