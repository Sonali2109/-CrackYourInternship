class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Solution {
    int[] dp;
    TrieNode root;
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();
        root = buildTrieNode(dictionary);
        dp = new int[len+1];
        Arrays.fill(dp, -1);
        helperFunction(s, 0, len);
        return dp[0];
    }

    public int helperFunction(String s, int currIdx, int len) {
        if(currIdx == len) {
            return 0;
        }
        if(dp[currIdx] != -1) {
            return dp[currIdx];
        }

        TrieNode node = root;
        int ans = 1 + helperFunction(s, currIdx+1, len);
        for(int i = currIdx; i < len; i++) {
            int ch = s.charAt(i)-'a';
            if(node.children[ch] == null) {
                break;
            }
            node = node.children[ch];
            if(node.isWord == true) {
                ans = Math.min(ans, helperFunction(s, i+1, len));
            }
        }
        return dp[currIdx] = ans;
    }

    public TrieNode buildTrieNode(String[] dictionary) {
    TrieNode root = new TrieNode();
    for(String word : dictionary) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    
    }
    return root;
}

}