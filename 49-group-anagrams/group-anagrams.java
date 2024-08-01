class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str: strs) {
            char[] arr = new char[26];
            for(char cur: str.toCharArray()) {
                arr[cur-'a']++;
            }
            String key = String.valueOf(arr);
            if(map.containsKey(key)) map.get(key).add(str);
            else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
                ans.add(list);
            }
        }

        // System.out.println(map);

        return ans;
    }
}