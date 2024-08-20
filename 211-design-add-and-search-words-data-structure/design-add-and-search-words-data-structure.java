class WordDictionary {
    
    class TrieNode {
        private TrieNode children[];
        private boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    public WordDictionary() {
        
        root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        
        TrieNode curr = root;
        
        for(char ch : word.toCharArray()) {
            
            if(curr.children[ch-'a'] == null) {
                TrieNode node = new TrieNode();
                curr.children[ch-'a'] = node;
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        //since we have "." chars in this one, we will use dfs
        return match(root, 0, word.toCharArray());
        
    }
    
    
    public boolean match(TrieNode node, int i, char[] word) {
        
        //we reached end of word char array, we return if it is a word
        if(i == word.length) return node.isWord;
        
        //encounter a ., then dfs char in the children array and see if there is a char availanle
        if(word[i] == '.') {
                for(int j=0; j<node.children.length; j++) {
                    if(node.children[j] != null && match(node.children[j], i+1, word)) {
                        return true;
                    }
            }        
        }
        else {
                return node.children[word[i] - 'a'] !=null && match(node.children[word[i] - 'a'], i+1, word);
            }
            return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */