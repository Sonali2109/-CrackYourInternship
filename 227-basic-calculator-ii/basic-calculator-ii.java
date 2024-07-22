class Solution {
    int result = 0;
    int previousNumber = 0;
    int currentNumber = 0;

    public int calculate(String s) {
        char operator = '+';
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char nextChar = s.charAt(i);

            if(Character.isDigit(nextChar)){
                currentNumber*=10;
                currentNumber += (int) nextChar - '0';
            } else if (!Character.isWhitespace(nextChar)) {
                pushToStack(currentNumber, operator, stack);
                currentNumber = 0;
                operator = nextChar;
            }
        }

        pushToStack(currentNumber, operator, stack);

        return result + previousNumber;
    }

    private void pushToStack(int currentNumber, char operator, Stack<Integer> stack){
        switch(operator){
            case '+': 
                result += previousNumber;
                previousNumber = currentNumber;
                break;
            case '-':
                result += previousNumber;
                previousNumber = currentNumber*-1;
                break;
            case '/':
                previousNumber /= currentNumber;
                break;
            case '*':
                previousNumber *= currentNumber;
                break;
        }
    }
}