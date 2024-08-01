class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String newSort = new String(temp);

            if(!map.containsKey(newSort))
            {
                map.put(newSort,new ArrayList<>());
            }
            map.get(newSort).add(s);
        }
        return new ArrayList<>(map.values());
    }
}