class Solution {

    static int dp[][];

    static int helper(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if(ch1==ch2){
            return dp[i][j] = 2+helper(s,i+1,j-1);
        }else{
            int a = helper(s,i+1,j);
            int b = helper(s,i,j-1);
            return dp[i][j] = Math.max(a,b);
        }
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];

        for(var a : dp) Arrays.fill(a,-1);
        return n-helper(s,0,n-1);
    }
}