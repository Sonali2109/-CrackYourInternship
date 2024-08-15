class Solution {
    static int arr[];
    static int n;
    static int dp[][];
    static int helper(int st, int end){
        if(st>end) return 0;

        if(dp[st][end]!=-1) return dp[st][end];
        int ans = 0;
        for(int i=st; i<=end; i++){
            int x = ((st-1)<0 ? 1 : arr[st-1]) * ((end+1)>=n ? 1 : arr[end+1]) * arr[i];
            x += (helper(st,i-1)+helper(i+1,end));
            ans = Math.max(ans,x);
        }
        return dp[st][end] = ans;
    }
    public int maxCoins(int[] nums) {
        arr = nums;
        n = arr.length;
        dp = new int[305][305];
        for(var a : dp) Arrays.fill(a,-1);
        return helper(0,n-1);
    }
}