
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        solve("",0,0,n,ans);
        return ans;                
    }

    static List<String> solve(String curr, int open, int close, int total, List<String> ans)
    {
        if(curr.length() == 2 * total)  //to check if we had created every paranthesis required (GOT THE ANSWER!!)
            ans.add(curr);

        if(open < total){
            solve(curr + "(" , open + 1, close, total, ans);
        }

        if(close < open){
            solve(curr + ")" , open, close + 1, total, ans);
        }

        return ans;
    }
}