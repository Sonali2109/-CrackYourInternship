class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair<Integer,Character>> mxheap ;
        mxheap = new PriorityQueue<>((a,b) -> a.getKey()!=b.getKey() ?  -a.getKey() + b.getKey() : a.getValue()- b.getValue());
        int i = 0 , n = s.length();
        int[] count = new int[26];
        for(i = 0 ; i  < n ;i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        for(i = 0 ; i < 26; i++)
            if(count[i] != 0)
                mxheap.add(new Pair(count[i], (char)('a'+i)));
        // System.out.println(mxheap);
        String ans = "";
        while( mxheap.size() > 0 ){
            int num = mxheap.peek().getKey();
            char c = mxheap.peek().getValue();
            mxheap.poll();
            
            ans+=c;
            boolean present = false;
            int num2 = 0;
            char c2 = ' ';
            if(mxheap.size() > 0 ){
                num2 = mxheap.peek().getKey();
                c2 = mxheap.peek().getValue();
                mxheap.poll();
                present = true;
                ans+=c2;
            }
//             System.out.println(num+"  "+c);
//             System.out.println(num2+"  "+c2);
            
//             System.out.println(ans);
            if(present && num2-1 > 0)
                mxheap.add(new Pair(num2-1, c2));
            if(num -1 > 0)
                mxheap.add(new Pair(num-1,c));
        }
        for(i = 1 ; i < ans.length(); i++){
            if(ans.charAt(i) == ans.charAt(i-1) )
                return "";
        }
        return ans;
    }
}