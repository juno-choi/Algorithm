package inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 */
public class ChangeUpperLower {
    public static void main(String[] args) {
        ChangeUpperLower ss = new ChangeUpperLower();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        String solution = ss.solution(str);
        System.out.print(solution);
    }

    public String solution(String str){
        String answer = "";
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)) answer += Character.toUpperCase(c);    //소문자인지 검사하는 방법
            else answer += Character.toLowerCase(c);
        }
        return answer;
    }
}
