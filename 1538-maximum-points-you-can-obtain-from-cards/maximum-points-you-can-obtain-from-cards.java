class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        maxsum=lsum;
        int j=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[j];
            j--;
            maxsum=Math.max(rsum+lsum,maxsum);
        }
        return maxsum;
    }
}