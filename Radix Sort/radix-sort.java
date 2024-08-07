class Solution
{
    static int getMax(int arr[], int n){
        int max=arr[0];
        for(int i=1; i<n; i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    
    static void countingsort(int arr[], int n, int exp){
        int[] output = new int[n];
        int[] count = new int[10];

        for(int i=0; i<n; i++){
            count[(arr[i]/exp)%10]++;
        }
        
        for(int i=1; i<10; i++){
            count[i]+=count[i-1];
        }
        
        for(int i=n-1; i>=0; i--){
            int digit = (arr[i] / exp) % 10; // current digit
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        for(int i=0; i<n; i++){
            arr[i]=output[i];
        }
    }
    
    static void radixSort(int arr[], int n) 
    { 
        int max = getMax(arr, n);
        
        for(int exp=1; max/exp>0; exp=exp*10){
            countingsort(arr, n, exp);
        }
        
    }
}
