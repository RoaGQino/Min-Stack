import java.util.Stack;

class MinStack {
  private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

   public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    
   public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
  public void pop() {
        if (mainStack.isEmpty()) return;
        int val = mainStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }
    
  public int top() {
        if (mainStack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return mainStack.peek();
    }
    
   public int getMin() {
        if (minStack.isEmpty()) throw new IllegalStateException("Stack is empty");
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); 
        minStack.pop();
        System.out.println(minStack.top());  
        System.out.println(minStack.getMin());
    }
}
