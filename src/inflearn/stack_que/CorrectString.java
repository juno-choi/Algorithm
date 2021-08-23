package inflearn.stack_que;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 *
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 */
public class CorrectString {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        String solution = solution(input1);
        System.out.println(solution);
    }
    public static String solution(String s){
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c=='(') stack.push("(");
            else if(c==')'){
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";
        return "YES";
    }
}
