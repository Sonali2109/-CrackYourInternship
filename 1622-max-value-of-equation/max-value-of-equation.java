class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) 
    {
        int max = Integer.MIN_VALUE; //assign the lowest number
        int res = 0;
        int mod = 0;
        int flag = 1;

        for(int i = 0;i<points.length-1;i++) //iteration over the points
        {
            if(flag<i+1)
                flag = i+1;
                
            for(int j = flag;j<points.length;j++) 
			//iteration over the points again so that we can deliver the variables in the equation
            {
                mod = points[i][0]-points[j][0]; 
                if(mod<0)
                    mod = -mod;
                if(mod>k)
                    break;
                res = points[i][1]+points[j][1]+mod; //final equation 
                if(max<res)
                {
                    max = res; //updation of max
                    flag = j-1;
                }
            }
        }
        return max;
    }
}