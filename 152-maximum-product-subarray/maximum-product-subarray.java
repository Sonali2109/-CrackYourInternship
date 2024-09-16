class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        double left = 1;
        double right = 1;
        double ans = nums[0];   //2 --> 2 --> 6

        for(int i=0; i<n; i++)
        {
            if(left == 0)   left = 1;
            if(right == 0)  right = 1;

            left = left * nums[i]; //2 --> 6
            right = right * nums[n-1-i];      //-2 --> -4

            ans = Math.max(ans, Math.max(left,right));
        }

        return (int) ans;
    }
}



















/*
        int n = nums.length;
        double left = 1;
        double right = 1;
        double ans = nums[0];

        for(int i=0; i<n; i++)
        {
            left = left==0 ? 1 : left;
            right = right==0 ? 1 : right;

            left *= nums[i];
            right *= nums[n-1-i];

            ans = Math.max(ans, Math.max(left,right));
        }

        return (int) ans;
*/