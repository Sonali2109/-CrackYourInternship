class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            while (!stack.isEmpty() && nums[i] < stack.peek() && nums.length - i > k - stack.size()) {
                stack.pop();
            }
            
          
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        
      
        for (int i = k-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}