class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        String[] p = path.split("/");


        for(String str: p){

            if(!str.isEmpty() && str.equals(".."))
                s.poll();
            else if(!str.isEmpty() && !str.equals("."))
                s.push(str);
        }

        if(s.isEmpty()) 
            return "/";
        
        while(!s.isEmpty()){
            sb.append("/").append(s.pollLast());
        }

        return sb.toString();

    }
}