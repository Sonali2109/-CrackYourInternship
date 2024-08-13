class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer>  list;

    public StockSpanner() {
        st=new Stack<>();
        list=new ArrayList<>();   
    }
    
    public int next(int price) {
        list.add(price);
        while(!st.isEmpty()&& list.get(st.peek())<=price){
            st.pop();
        }
        int previousGreatestIndex= st.isEmpty()?-1:st.peek();
        int ans=(list.size()-1)-previousGreatestIndex;
        st.push(list.size()-1);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */