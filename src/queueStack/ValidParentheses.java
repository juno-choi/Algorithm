package queueStack;

import java.util.Stack;

public class ValidParentheses {

    /**
     * 오픈 가로들을 먼저 스택에 넣는다
     * 클로즈 가로들이 나오면 뺀다
     * 최종으로 stack에 남아있나를 체크한다
     */
    public static void main(String[] args) {
        //String exp = "([)]";
        String exp = "()[]{}(";
        System.out.println(isValid(exp));
    }

    public static boolean isValid(String s){
        if(s.length()%2 != 0) return false;
        //1 structure
        Stack<Character> stack = new Stack<>();

        //2 for while
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case ')':
                    if(!stack.empty() && stack.peek() == '(') stack.pop();
                    break;
                case ']':
                    if(!stack.empty() && stack.peek() == '[') stack.pop();
                    break;
                case '}':
                    if(!stack.empty() && stack.peek() == '{') stack.pop();
                    break;
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }


}
