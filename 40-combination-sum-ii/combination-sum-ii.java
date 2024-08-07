class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        backtrack(0,candidates,new  ArrayList(),res,target);
        return res;
    }

    public void backtrack(int start, int[] nums, List<Integer> cur, List<List<Integer>> res, int target)
    {
        if(target == 0)
        {
            res.add(new ArrayList(cur));
            return;
        }

        if(target<0)
            return;

        for(int i=start; i<nums.length; i++)
        {
            if(i>start && nums[i] == nums[i-1])
                continue;
            
            cur.add(nums[i]);
            backtrack(i+1,nums,cur,res,target - nums[i]);
            cur.remove(cur.size()-1);
        }
    }
}