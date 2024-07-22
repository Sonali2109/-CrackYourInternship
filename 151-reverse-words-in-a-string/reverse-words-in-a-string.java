import java.util.*;
class Solution {
    public String reverseWords(String s) 
    {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        String res = "";

        for (int i = str.length - 1; i > 0; i--) {
            res += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return res + str[0];
    }
}