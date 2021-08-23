package inflearn.stack_que;

import java.util.Scanner;
import java.util.Stack;

/**
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 */
public class ParenthesisString {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        String solution = solution2(input1);
        System.out.println(solution);
    }
    public static String solution(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : chars){
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty()) stack.pop();
            }else{
                if(stack.isEmpty()) sb.append(c);
            }
        }

        return sb.toString();
    }
    public static String solution2(String s){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c==')'){
                if(stack.isEmpty()) return "실패";
                while(stack.pop() != '(');
            }else
                stack.push(c);
        }

        for(char c : stack){
            answer += String.valueOf(c);
        }
        return answer;
    }
}
