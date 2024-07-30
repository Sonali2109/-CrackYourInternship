class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=nums2.length-1;i>=0;i--)
        {
            if(stack.isEmpty()) {
                stack.push(nums2[i]);
                map.put(nums2[i],-1);
            }
            else {
                while(!stack.isEmpty() && nums2[i]>=stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(nums2[i],-1);
                }else{
                    map.put(nums2[i],stack.peek());
                }
                stack.push(nums2[i]);
            }
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]= map.get(nums1[i]);
        }

        return nums1;
    }
}