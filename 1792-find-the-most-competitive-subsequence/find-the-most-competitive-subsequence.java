class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
         int[] arr = new int[k];
       int ind = 0;
       for(int i=0;i<nums.length;i++){
           while(ind > 0 && nums[i] < arr[ind-1] && ind+nums.length-i-1 >= k ){
               ind--;
           }
           if(ind<k){
               arr[ind++] = nums[i];
           }
       }
       return arr;
    }
}