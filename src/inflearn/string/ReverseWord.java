package inflearn.string;

import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 * 설명
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 */
public class ReverseWord {
    //1. StringBuilder reverse를 이용하는 방법
    /*public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        for(int i=0; i<input1; i++){
            String input2 = in.next();
            StringBuilder sb = new StringBuilder(input2);
            System.out.println(sb.reverse().toString());
        }
    }*/
    //2. 직접 reverse를 구현
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        for(int i=0; i<input1; i++){
            String str = in.next();
            char[] chars = str.toCharArray();
            int start = 0;
            int end = chars.length-1;
            while(start<end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
            System.out.println("new String(chars) = " + new String(chars));
        }
    }
}
