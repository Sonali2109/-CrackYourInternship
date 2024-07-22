import java.util.*;

class Solution {
    public boolean isValid(String s) 
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            char brackets = s.charAt(i);

            if(brackets == '(' || brackets == '{' || brackets == '[')
                stack.push(brackets);
            else{
                if(stack.isEmpty())   return false;

                char opening = stack.pop();
                if((opening == '(' && brackets == ')') || (opening == '{' && brackets == '}') || (opening == '[' && brackets == ']'))   
                    continue;
                else 
                    return false;
            }
        }

        return stack.isEmpty();
    }
}