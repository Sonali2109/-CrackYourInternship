class Solution {
    public String reverseWords(String s) 
    {
        String str[] = s.split(" ");
        StringBuilder sc = new StringBuilder();

        for(int i=str.length-1;i>=0;i--)
        {
            if(str[i]!= ""){
                sc.append(str[i]);
                sc.append(" ");
            }

        }
        return sc.toString().trim();
    }
}