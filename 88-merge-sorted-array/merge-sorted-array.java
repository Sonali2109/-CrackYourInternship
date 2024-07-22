import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        if(nums2.length==0) return;
        if(nums1.length==1 && nums1[0] == 0){
            nums1[0] = nums2[0];
            return;
        }

        int res[] = Arrays.copyOf(nums1 , m+n);
        int i=0, j=0, p=0;

        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                res[p] = nums1[i];
                p++;
                i++;
            }
            else{
                res[p] = nums2[j];
                p++;
                j++;
            }
        }

        while(i<m){
            res[p++] = nums1[i];
            i++;
        }

        while(j<n){
            res[p++] = nums2[j];
            j++;
        }

        System.arraycopy(res, 0, nums1, 0, m+n);
    }
}