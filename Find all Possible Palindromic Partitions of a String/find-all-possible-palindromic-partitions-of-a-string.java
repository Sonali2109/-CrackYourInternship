class Solution {
    static void solve(ArrayList<ArrayList<String>>ans,ArrayList<String>path,String S,int index){
        if(index==S.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<S.length();i++){
            if(isPal(S,index,i)){
                path.add(S.substring(index,i+1));
                solve(ans,path,S,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    
    static boolean isPal(String S,int start,int end){
        while(start<=end){
            if(S.charAt(start++)!=S.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        ArrayList<String>path=new ArrayList<>();
        solve(ans,path,S,0);
        return ans;
    }
};
