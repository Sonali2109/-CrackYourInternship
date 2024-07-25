class Solution {
    public boolean isNumber(String s) {
        boolean numFlag = false;
        boolean expoFlag = false;
        boolean dotFlag = false;

        for(int i=0; i<s.length(); i++)
        {
            char cur = s.charAt(i);

            if(Character.isDigit(cur))  
                numFlag = true;
            else if(cur == '+' || cur == '-'){
                if(i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))
                    return false;
            }
            else if(cur == '.'){
                if(dotFlag || expoFlag)
                    return false;
                dotFlag = true;
            }
            else if(cur == 'e' || cur == 'E') {
                if (expoFlag || !numFlag)
                    return false;
                expoFlag = true;
                numFlag = false;
            } else {
                return false; 
            }
        }
        
        return numFlag;
    }
}