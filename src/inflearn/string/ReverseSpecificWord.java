package inflearn.string;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 5. 특정 문자 뒤집기
 * 설명
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 */
public class ReverseSpecificWord {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();

        char[] chars = input.toCharArray();
        int charLeng = chars.length;
        int start = 0;
        int end = charLeng-1;
        while(start<end){
            char word1 = chars[start];
            char word2 = chars[end];
            String check = "^[a-zA-Z]*$";
            if(!Pattern.matches(check, word1+"")){
                start++;
            }else if(!Pattern.matches(check, word2+"")){
                end--;
            }else{
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(new String(chars));
    }
}
