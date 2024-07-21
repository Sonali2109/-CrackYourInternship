import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) 
    {
        List<Integer> list = new ArrayList<>(); 
        int arr[] = new int[nums.length];

        for(int i=0; i<nums.length; i++)
        {
            arr[nums[i] - 1] += 1;
        }

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > 1){
                list.add(i+1);
            }
        }

        return list;
    }
}