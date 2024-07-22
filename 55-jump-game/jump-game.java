class Solution {
    public boolean canJump(int[] nums) {
        int steps = 0;

        for(int i=0; i<nums.length; i++)        //0,1
        {
            if(steps < i)    return false;

            steps = Math.max(steps,i+nums[i]);      //3

            if(steps >= nums.length-1)  return true;
        }

        return false;
    }
}