class Solution {
    public int mctFromLeafValues(int[] arr) {
        int cost = 0;
        Stack<Integer> s = new Stack<>();
        s.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (s.peek() <= a) {
                int mid = s.pop();
                cost += mid * Math.min(s.peek(), a);
            }
            s.push(a);
        }
        while (s.size() > 2) {
            cost += s.pop() * s.peek();
        }
        return cost;        
    }
}