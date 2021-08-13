package inflearn.twopointer_slidingwindow;

import java.util.Scanner;

/**
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 N=15이면
 *
 * 7+8=15
 *
 * 4+5+6=15
 *
 * 1+2+3+4+5=15
 *
 * 와 같이 총 3가지의 경우가 존재한다.
 */
public class ContinueNatureNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int solution = solution(input1);
        System.out.println(solution);
    }
    public static int solution(int m){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int n = m/2+1;
        int[] natureNumber = new int[n];
        for(int i=0; i<n; i++){
            natureNumber[i] = i+1;
        }
        for(int rt = 0; rt<n; rt++){
            sum+=natureNumber[rt];
            if(sum == m) answer++;
            while(sum>=m){
                sum-=natureNumber[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }
}
