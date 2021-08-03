package inflearn.string;

import java.util.Scanner;

/**
 * 설명
 *
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *
 * 문장속의 각 단어는 공백으로 구분됩니다.
 */
public class WordOfString {
    public static void main(String[] args) {
        WordOfString ss = new WordOfString();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        String solution = ss.solution(str);
        System.out.print(solution);
    }

    public String solution(String str){
        String answer = "";
        int m = 0;
        String[] strs = str.split(" ");
        for(String s : strs){
            int leng = s.length();
            if(m<leng){
                m = leng;
                answer = s;
            }
        }
        return answer;
    }
}
