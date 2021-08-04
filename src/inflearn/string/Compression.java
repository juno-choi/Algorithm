package inflearn.string;

import java.util.Scanner;

/**
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 *
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 */
public class Compression {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //String input = in.next();
        String input = "KSTTTSEEKFKKKDJJGG";
        solution2(input);
    }
    //while을 이용한 풀이
    public static void solution(String input){
        char p = '가';
        StringBuilder sb = new StringBuilder();

        char[] chars = input.toCharArray();
        for(int i=0; i<chars.length; i++){
            int idx = 1;
            char c = chars[i];
            if(p!=c){
                p = c;
                sb.append(c);
            }else{
                while(i<=chars.length){
                    idx++;
                    i++;
                    if(i>=chars.length){
                        i--;
                        break;
                    }
                    char d = chars[i];

                    if(p!=d){
                        i--;
                        break;
                    }
                }
                sb.append(idx);
            }
        }
        System.out.println(sb.toString());
    }
    
    //문자열에 마지막 공백을 추가하는 방법
    public static void solution2(String input){
        input = input+" ";
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        char[] chars = input.toCharArray();
        for(int i=0; i<chars.length-1; i++){
            char c1 = chars[i];
            char c2 = chars[i+1];
            if(c1==c2) idx++;
            else{
                sb.append(c1);
                if(idx>1)sb.append(idx);
                idx = 1;
            }
        }

        System.out.println(sb.toString());
    }
}