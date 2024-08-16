// User function Template for Java

class Solution {
    public int MinCoin(int[] nums, int amount) {
        // Code here
        int[] prev = new int[amount+1];
        for(int i = 0; i <= amount; i++){
            if(i%nums[0] == 0)prev[i] = i/nums[0];
            else prev[i] = 1000000000;
        }
        
        for(int i = 1;i < nums.length; i++){
            int[] curr = new int[amount+1];
            //curr[0] = 1;
            for(int j = 1; j <= amount; j++){
                int pick = 1000000000;
                if(j >= nums[i]){
                    pick = 1+curr[j-nums[i]];
                }
                int notPick = prev[j];
                curr[j] = Math.min(pick, notPick);
            }
            prev = curr;
            //System.out.println(Arrays.toString(prev));
        }
        if(prev[amount] == 1000000000)return -1;
        return prev[amount];
    }
}
