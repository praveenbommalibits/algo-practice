package com.algopractice.stack;

import java.util.Stack;

public class MinStack1 {

    Stack<Long> minStack = new Stack<>();
    Long minVal ;
    public MinStack1() {
        minVal  = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long  lVal = Long.valueOf(val);
        if(minStack.isEmpty()) {
            minVal=  lVal;
            minStack.push(lVal);
        }
        if (val <= minVal ) {
            minStack.push(2*lVal-minVal);
            minVal = lVal;
        } else{
            minStack.push(lVal);
        }
    }

    public void pop() {
       if(!minStack.isEmpty()) {
           Long ele = minStack.peek();
           minStack.pop();
           if(ele < minVal) {
                minVal = 2*minVal-ele; //rollback
           }
       }

    }

    public int top() {
        if(minStack.isEmpty()) return -1;

        Long element = minStack.peek();
        if(element < minVal) {
            return Math.toIntExact(minVal);
        }
        return Math.toIntExact(element);
    }

    public int getMin() {
        return Math.toIntExact(minVal);
    }
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
