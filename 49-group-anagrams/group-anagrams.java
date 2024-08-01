class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charArr = str.toCharArray(); // 5,1,2,4,3 --> 1,2,3,4,5
            Arrays.sort(charArr); //klogk
            String sorted = String.valueOf(charArr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}