package com.algopractice.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{""}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<>();
        for(String s : tokens) {
            switch (s) {
                case "+":
                    operandStack.push(operandStack.pop() + operandStack.pop());
                    break;
                case "-":
                    int b = operandStack.pop();
                    int a  = operandStack.pop();
                    operandStack.push(a-b);
                    break;
                case "/":
                    b = operandStack.pop();
                    a  = operandStack.pop();
                    operandStack.push(a/b);
                    break;
                case "*":
                    operandStack.push(operandStack.pop() * operandStack.pop());
                    break;
                default :
                    operandStack.push(Integer.parseInt(s));
                    break;
            }
        }
        return operandStack.pop();
    }
}
