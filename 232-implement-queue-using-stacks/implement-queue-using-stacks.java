import java.util.*;
class MyQueue {

    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();

    public MyQueue() {}
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty())    return -1;
        if(!stack2.isEmpty()){
            int top = stack2.peek();
            stack2.pop();
            return top;
        }
        else{
            while(!stack1.isEmpty())
            {
                int top = stack1.peek();
                stack1.pop();
                stack2.push(top);
            }
        }

        int top = stack2.peek();
        stack2.pop();
        return top;
    }
    
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                int top = stack1.peek();
                stack1.pop();
                stack2.push(top);
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */