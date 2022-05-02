package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/23628
 *
2021 11 21
2022 11 22
 *
 */
public class B23628 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input1 = bf.readLine().trim();
        String input2 = bf.readLine().trim();

        sb.append(solve(input1, input2));
        System.out.print(sb);
    }
    public static String solve(String input1, String input2){
        //근무 시작
        String[] S = input1.split(" ");
        //근무 종료
        String[] E = input2.split(" ");

        //총 근무 계산
        int year = (Integer.valueOf(E[0]) - Integer.valueOf(S[0])) * 360;
        int month = (Integer.valueOf(E[1]) - Integer.valueOf(S[1])) * 30;
        int day = (Integer.valueOf(E[2]) - Integer.valueOf(S[2]));

        //총 근무
        int days = year+month+day;

        //연차 계산
        int years = year/360;
        int Y = 0;
        int A = 0;
        int flag = 0;
        if(days >= 360) {
            while (years > 0) {
                flag++;
                years--;
                Y += 15 + A;
                if (flag >= 2) {
                    A++;
                    flag = 0;
                }
            }
        }
        //월차 계산
        int M = days/30;
        if(M>36) M = 36;

        return String.format("%d %d\n%ddays",Y,M,days);
    }
}
