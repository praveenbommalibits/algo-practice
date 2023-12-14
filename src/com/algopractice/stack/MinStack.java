package com.algopractice.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack = new Stack<>();
    Integer minVal = Integer.MAX_VALUE;
    public MinStack() {
    }

    public void push(int val) {
        if (val <= minVal ) {
            minStack.push(minVal);
            minVal = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if(!minStack.isEmpty() && minStack.pop() == minVal)
            minVal = minStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minVal;
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
