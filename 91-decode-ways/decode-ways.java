class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            int second = s.charAt(i) - '0';
            int two = first * 10 + second;
            if (two >= 10 && two <= 26) dp[i + 1] += dp[i - 1];
            if (second != 0) dp[i + 1] += dp[i];
        }
        return dp[s.length()];
    }
}