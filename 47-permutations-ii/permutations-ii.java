class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
     List<List<Integer>> list = new ArrayList<List<Integer>>();
     getPermuteUnique(nums , list , 0);
     return list;   
    }

    public void getPermuteUnique(int[] nums , List<List<Integer>> list , int index ){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<Integer>();
            for(int i : nums){
                temp.add(i);
            }
            list.add(temp);
        } 

        for(int j = index;j<nums.length ;j++){
            boolean isMatched = false;

             for(int r =j-1;r>=index;r--){
                if(nums[j]==nums[r]){
                  isMatched = true;  
                }
             }
             if(isMatched){
                continue;
             }

            swap(nums,index,j);
            getPermuteUnique(nums,list,index+1);
            swap(nums,index,j);
        }
    }

    public void swap(int[] nums , int p ,int q){
        int tValue = nums[p];
        nums[p] = nums[q];
        nums[q]=tValue;
    }
}