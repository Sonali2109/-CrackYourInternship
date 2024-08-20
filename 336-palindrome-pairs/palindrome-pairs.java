class Solution {

    int wordMaxLength = 301;
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        Map<String, Integer> map = new HashMap<>(n << 2);
        boolean[] seen = new boolean[wordMaxLength];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            map.put(word, i);
            seen[word.length()] = true;
        }

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if (m == 0) continue;
            char[] cs = word.toCharArray();
            String re = new StringBuilder(word).reverse().toString();

            for (int j = 0; j < m - 1; j++) {
                if (seen[j + 1] && isPalindrome(cs, j + 1, m - 1)) {
                    String s = re.substring(m - j - 1, m);
                    Integer k = map.get(s);
                    if (k != null){
                        ans.add(List.of(i, k));
                    }
                }
                if (seen[m - j - 1] && isPalindrome(cs, 0, j)) {
                    String s = re.substring(0, m - j - 1);
                    Integer k = map.get(s);
                    if (k != null){
                        ans.add(List.of(k, i));
                    }
                }
            }

            if (isPalindrome(cs, 0, m - 1)) {
                Integer k = map.get("");
                if (k != null) {
                    ans.add(List.of(k, i));
                    ans.add(List.of(i, k));
                }
            } else {
                Integer k = map.get(re);
                if (k != null) {
                    ans.add(List.of(i, k));
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(char[] cs, int left, int right) {
        while (left < right) {
            if (cs[left] != cs[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}