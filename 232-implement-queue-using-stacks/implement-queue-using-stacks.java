class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int removed_item = helper.pop();
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return removed_item;
    }
    
    public int peek() {

        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int item = helper.lastElement();
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return item;
        
    }
    
    public boolean empty() {
        if(stack.isEmpty()){
            return true;
        }
        return false;
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