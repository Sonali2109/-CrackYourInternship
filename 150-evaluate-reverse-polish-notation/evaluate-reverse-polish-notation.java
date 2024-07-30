class Solution {
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> st=new Stack<>();
        String operators="+-/*";

        for(String token : tokens)
        {
            if(operators.indexOf(token)!=-1){
                int d2=st.pop();
                int d1=st.pop();
                int res=0;
                if(token.equals("+")){
                    res=d1+d2;
                }else if(token.equals("-")){
                    res=d1-d2;
                }else if(token.equals("*")){
                    res=d1*d2;
                }else if(token.equals("/")){
                    res=d1/d2;
                }
                st.push(res);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}