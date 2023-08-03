package codility;

import java.util.Stack;

public class C8M1 {
    public static void main(String[] args) {
        String S = "{[()()]}";
        int solution = solution(S);
        System.out.println(solution);
    }
    private static int solution(String S){
        char[] charArray = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : charArray){
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }

                Character pop = stack.pop();
                if((c == ']' && pop != '[') || (c == '}' && pop != '{') || (c == ')' && pop != '(')){
                    return 0;
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
