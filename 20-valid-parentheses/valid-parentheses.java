import java.util.*;

class Solution {
    public boolean isValid(String s) 
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())   return false;

                char opening = stack.pop();
                if((opening == '(' && s.charAt(i) == ')') || (opening == '{' && s.charAt(i) == '}') || (opening == '[' && s.charAt(i) == ']'))   
                    continue;
                else 
                    return false;
            }
        }

        return stack.isEmpty();
    }
}