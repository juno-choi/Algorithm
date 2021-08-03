package inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 *
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 *
 */
public class StringSearch {
    public static void main(String[] args) {
        StringSearch ss = new StringSearch();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        int solution = ss.solution(str, c);
        System.out.print(solution);
    }

    public int solution(String str, char c){
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);   //char 대문자로 변환
        char[] chars = str.toCharArray();
        for(char ch : chars){
            if(ch==c){
                answer++;
            }
        }
        return answer;
    }
}
