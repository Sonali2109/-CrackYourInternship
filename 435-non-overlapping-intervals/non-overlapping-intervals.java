class Solution{
    public int eraseOverlapIntervals(int[][] in) {
        int min = in[0][1];
        int max = in[0][1];

        for(int i[]:in){
            min = Math.min(min,i[1]);
            max = Math.max(max,i[1]);
        }

        int a[] = new int[max-min+1];
        Arrays.fill(a,-1);
        for(int i[]:in){
            if(a[i[1]-min]==-1 || a[i[1]-min]<i[0]-min)
                a[i[1]-min] = i[0]-min;
        }

        int k = 1;
        int e = 0;

        for(int i=1;i<a.length;i++){
            if(a[i]==-1) continue;
            if(a[i]>=e){
                k++;
                e = i;
            }
        }
        return in.length-k;
    }
}