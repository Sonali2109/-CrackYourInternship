class Solution {
    public List<Integer> diffWaysToCompute(String expr) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<expr.length(); i++)
        {
            char ch = expr.charAt(i);

            if(ch == '-' || ch == '+' || ch == '*'){
                String left = expr.substring(0,i);
                String right = expr.substring(i+1);   

                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);

                for(int x: leftRes)
                {
                    for(int y: rightRes)
                    {
                        if(ch == '+')
                            res.add(x+y);
                        else if(ch == '-')
                            res.add(x-y);
                        else
                            res.add(x*y);
                    }
                }
            }
        }

        if(res.size() == 0)
            res.add(Integer.parseInt(expr));
        return res;
    }
}