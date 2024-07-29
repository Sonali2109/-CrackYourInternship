class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0 , nums.length-1);              
    }

    static int mergeSort(int[] nums, int low, int high)
    {
        if(low>=high)   return 0;
        
        int mid = (low + high) / 2;
        int interval = 0;
        interval += mergeSort(nums,low,mid);
        interval += mergeSort(nums,mid+1,high);
        interval += merge(nums,low,mid,high);

        return  interval;
    }

    //main code for this problem statement
    static int merge(int[] nums, int low, int mid, int high)
    {
        int count = 0;
        int j = mid+1;  //right half of the array

        for(int i=low; i<=mid; i++)
        {
            while(j<=high && nums[i] > (2 * (long)nums[j])){
                j++;
            }
            count += j - (mid+1); // count the items present in the left half
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int left = low , right = mid+1;

        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])   
                arr.add(nums[left++]);
            else
                arr.add(nums[right++]);
        }

        while(left<=mid){
            arr.add(nums[left++]);
        }

        while(right<=high){
            arr.add(nums[right++]);
        }

        for(int i=low; i<=high; i++)
        {
            nums[i] = arr.get(i-low);
        }

        return count;
    }
}