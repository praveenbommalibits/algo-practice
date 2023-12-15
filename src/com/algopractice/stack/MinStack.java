package com.algopractice.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public void push(int x) {
        if(x<=min) {stack.push(min); min=x;}
        stack.push(x);
    }
    public void pop() {
        if(stack.peek()==min){ stack.pop(); min=stack.pop(); }
        else stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
