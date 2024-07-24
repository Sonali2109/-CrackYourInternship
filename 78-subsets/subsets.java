import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(nums);
        subSequenceArray(nums, ans, cur, 0);
        return ans;
    }

    static void subSequenceArray(int[] nums, List<List<Integer>> ans, List<Integer> cur, int index)
    {
        ans.add(new ArrayList<>(cur));

        for(int i=index; i<nums.length; i++)
        {
            if(i>index && nums[i] == nums[i-1]) continue;

            cur.add(nums[i]);
            subSequenceArray(nums,ans,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}