class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int idx = 0;
        int jdx = 1;
        int res = 0;
        while(idx < arr.length && jdx < arr.length){
            if(arr[idx]==arr[jdx]){
                if(neededTime[idx]>neededTime[jdx]){
                    res+=neededTime[jdx];
                    jdx++;
                }else{
                    res+=neededTime[idx];
                    idx = jdx;
                    jdx++;
                }
            }else{
                idx=jdx;
                jdx++;
            }
        }
        return res;
    }
}