class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1)  System.out.println(nums);

        int k = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }

        for(int i=k; i<nums.length; i++){
            nums[i] = 0;
        }

        System.out.println(nums);
    }
}