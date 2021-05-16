package queueStack;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(solve(strs));
    }

    public static int solve(String[] strs){
        //1. structure
        Stack<Integer> stack = new Stack<>();

        //2. for while
        for(String s : strs){
            switch (s){
                case "C" :
                    stack.pop();
                    break;
                case "D" :
                    stack.push(stack.peek()*2);
                    break;
                case "+" :
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = a+b;
                    stack.push(b);
                    stack.push(a);
                    stack.push(c);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
