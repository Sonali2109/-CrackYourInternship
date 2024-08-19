class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxlen=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                maxlen=i+1;
            }else{
                if(map.containsKey(sum)){
                    maxlen=Math.max(maxlen,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return maxlen;
    }
}
