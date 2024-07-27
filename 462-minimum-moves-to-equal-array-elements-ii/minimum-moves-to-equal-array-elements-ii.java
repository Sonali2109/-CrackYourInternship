class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1)    return 0;

        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n/2];  
        int steps = 0;

        for(int num: nums)
        {
            steps += Math.abs(num-median);
        }

        return steps;
    }
}