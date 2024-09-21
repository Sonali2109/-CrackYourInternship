class Solution {
    private static void dfs(int curr, int target, List<Integer> res)
    {
        if(curr > target)   return;

        res.add(curr);

        for(int digit=0; digit<10; digit++)
        {
            if(curr * 10 + digit > target)
                break;
            dfs(curr * 10 + digit, target, res);        //ex: curr => 1*10+1 = 11 till 1*10+9 = 19
        }
    }

    public List<Integer> lexicalOrder(int n) 
    {
        List<Integer> res = new ArrayList<>();

        for(int i=1; i<10; i++){
            if(i>n) break;
            dfs(i,n,res);
        }

        return res;        
    }
}