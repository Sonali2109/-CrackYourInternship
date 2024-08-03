class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, max = 0, result = 0;
        int[] map = new int[26];
        for(int end = 0; end < s.length(); end++) {
            map[s.charAt(end) - 'A']++;
            max = Math.max(max, map[s.charAt(end) - 'A']);
            while (end - start + 1 - max > k) map[s.charAt(start++) - 'A']--;
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}