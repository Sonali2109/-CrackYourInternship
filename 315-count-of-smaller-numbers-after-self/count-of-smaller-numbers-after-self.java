class Solution {
    static int[] count;

    public List<Integer> countSmaller(int[] nums) 
    {
        List<Integer> res = new ArrayList<>();
        count = new int[nums.length];
        int[] origInd = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            origInd[i] = i;
        }

        sort(nums, origInd, 0, nums.length-1);

        for(int i=0; i<nums.length; i++){
            res.add(count[i]);
        }

        return res;
    }

    private static void sort(int[] arr, int[] origInd, int l, int r)
    {
        if(l<r){
            int mid = (l+r) / 2;
            sort(arr, origInd, l, mid);
            sort(arr, origInd, mid+1, r);
            merge(arr, origInd, l, mid, r);
        }
    }

    private static void merge(int[] arr, int[] origInd, int l, int mid, int r)
    {
        int lsize = mid-l+1;
        int rsize = r-mid;

        int[] larr = new int[lsize];
        int[] rarr = new int[rsize];

        for(int i=0; i<lsize; i++){
            larr[i] = origInd[l + i];
        }

        for(int i=0; i<rsize; i++){
            rarr[i] = origInd[i + mid+1];
        }

        int i=0,j=0,k=l,rightCount = 0;

        while(i<lsize && j<rsize){
            if(arr[larr[i]] <= arr[rarr[j]]){
                origInd[k] = larr[i];
                count[larr[i]] += rightCount;
                i++;
            }
            else{
                origInd[k] = rarr[j];
                rightCount++;
                j++;
            }
            k++;
        }

        while(i<lsize){
            origInd[k] = larr[i];
            count[larr[i]] += rightCount;
            i++;
            k++;
        }

        while(j<rsize){
            origInd[k] = rarr[j];
            j++;
            k++;
        }
    }
}