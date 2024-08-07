class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    static void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> list,boolean[] freq){
        if(list.size() == nums.length && !ans.contains(list)){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(freq[i])
                continue;

            freq[i] = true;
            list.add(nums[i]);

            backtrack(nums,ans,list,freq);

            freq[i] = false;
            list.remove(list.size()-1);
        }
    }
}