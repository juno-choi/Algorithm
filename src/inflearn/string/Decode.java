package inflearn.string;

import java.util.Scanner;

/**
 * 현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.
 *
 * 비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.
 *
 * 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
 *
 * 현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.
 */
public class Decode {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        String input2 = in.next();
        solution(input1, input2);
    }
    public static void solution(int input1, String input2){
        input2 = input2.replace("#", "1").replace("*", "0");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input1; i++){
            String str = input2.substring(0, 7);
            input2 = input2.substring(7);
            int parse = Integer.parseInt(str, 2);
            char c = (char) parse;
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
