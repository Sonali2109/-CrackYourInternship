class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for(int i = 0; i < n; i++){
            if(i < k - 1){
                mq.push(nums[i]);
            }else{
                mq.push(nums[i]);
                res[i - k + 1] = mq.getMax();
                mq.pop(nums[i - k + 1]);
            }
        }

        return res;  
    }
}

class MonotonicQueue{
    private LinkedList<Integer> maxq;

    public MonotonicQueue(){
        maxq = new LinkedList<>();
    }

    public void push(int n){
        while(!maxq.isEmpty() && maxq.getLast() < n){
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    public int getMax(){
        return maxq.getFirst();
    }

    public void pop(int n){
        if(n == maxq.getFirst()){
            maxq.pollFirst();
        }
    }
}