class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int time = 0;
        
        for (int i = 0; i < n; i++){
            int j = i + 1;
            int count = 1, maxTime = neededTime[i], sum = neededTime[i];
            while (j < n && colors.charAt(i) == colors.charAt(j)){
                maxTime = Math.max(maxTime, neededTime[j]);
                sum += neededTime[j];
                count++; j++;
            }
            if (count > 1) time += sum - maxTime;
            i = j - 1;
        }
        return time;
    }
}