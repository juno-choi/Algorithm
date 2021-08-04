package inflearn.string;

import java.util.Scanner;

/**
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 좌에서 탐색 우에서 탐색하는 것이 중요!
 */
public class CharacterDistance {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        solution(input1, input2);
    }
    public static void solution(String input1, String target){
        //String을 char 배열로 변경하여 순회하고
        //char 배열의 길이만큼 저장해둘 배열을 만들어둬야함
        char[] chars = input1.toCharArray();
        int length = chars.length;
        int[] answer = new int[length];
        int p = 1000; //기준이 되는 수 (문제의 제한사항에 문자사이의 거리는 100을 넘기지 않는다고 했으므로 더 큰 수를 기준으로 잡음)

        //좌에서 우로 탐색
        for(int i=0; i<length; i++){
            String s = String.valueOf(chars[i]);
            if(target.equals(s)){
                p = 0;
                answer[i] = p;
            }else{
                answer[i] = ++p;
            }
        }
        //우에서 좌로 탐색
        for(int i=length-1; i>=0; i--){
            String s = String.valueOf(chars[i]);
            if(target.equals(s)){
                p = 0;
                answer[i] = p;
            }else{
                int su = answer[i];
                p++;
                if(su>p){
                    answer[i] = p;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
