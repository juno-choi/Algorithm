package inflearn.stack_que;

import java.util.Scanner;
import java.util.Stack;

/**
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 *
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 */
public class Postfix {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        int solution = solution2(input1);
        System.out.println(solution);
    }

    public static int solution(String s){
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(char c : chars){
            if(c=='+'){
                if(!stack.isEmpty()){
                    int su1 = stack.pop();
                    int su2 = stack.pop();

                    stack.push(su2+su1);
                }
            }else if(c=='-'){
                if(!stack.isEmpty()){
                    int su1 = stack.pop();
                    int su2 = stack.pop();

                    stack.push(su2-su1);
                }
            }else if(c=='*'){
                if(!stack.isEmpty()){
                    int su1 = stack.pop();
                    int su2 = stack.pop();

                    stack.push(su2*su1);
                }
            }else if(c=='/'){
                if(!stack.isEmpty()){
                    int su1 = stack.pop();
                    int su2 = stack.pop();

                    stack.push(su2/su1);
                }
            }else{  //숫자인 경우
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }

        return stack.pop();
    }

    public static int solution2(String s){
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) stack.push(c-48);  //숫자값으로 변경하기 위해 값 character의 값 차이만큼 빼줌
            else{
                int su1 = stack.pop();
                int su2 = stack.pop();
                if(c == '+') stack.push(su2+su1);
                else if(c == '-') stack.push(su2-su1);
                else if(c == '*') stack.push(su2*su1);
                else if(c == '/') stack.push(su2/su1);
            }
        }

        return stack.pop();
    }
}
