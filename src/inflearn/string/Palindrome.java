package inflearn.string;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 *
 * 알파벳 이외의 문자들의 무시합니다.
 */
public class Palindrome {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        String input1 = input.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] chars = input1.toCharArray();
        String check = "^[a-zA-Z]*$";
        for(char c : chars){
            if(Pattern.matches(check, c+"")){
                sb.append(c);
            }
        }

        input1 = sb.toString();
        chars = input1.toCharArray();

        int start = 0;
        int end = chars.length-1;
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        String input2 = String.valueOf(chars);

        String answer = input1.equals(input2) ? "YES" : "NO";
        System.out.println(answer);
    }
}
