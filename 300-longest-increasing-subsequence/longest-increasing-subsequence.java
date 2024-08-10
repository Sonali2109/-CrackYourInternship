class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            if(list.size()>0&&i>list.get(list.size()-1)) list.add(i);
            else {
                int ind=lowBound(list,i);
                if(list.size()==0) list.add(i);
                else list.set(ind,i);
            }
        }
        return list.size();
    }
    public int lowBound(List<Integer> nums,int k){
        int start=0;
        int end=nums.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums.get(mid)==k) return mid;
            if(nums.get(mid)>k) end=mid-1;
            else start=mid+1; 
        }
        return start;
    }
}