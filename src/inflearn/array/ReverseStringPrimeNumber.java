package inflearn.array;

import java.util.Scanner;

/**
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 *
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 *
 * 첫 자리부터의 연속된 0은 무시한다.
 *
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 */
public class ReverseStringPrimeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input = in.nextInt();
        int[] arr = new int[input];
        for(int i=0; i<input; i++){
            arr[i] = in.nextInt();
        }
        solution(arr);
    }
    public static void solution(int[] arr){
        for(int i =0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder(arr[i]+"");
            int su = Integer.parseInt(sb.reverse().toString());
            boolean flag = true;
            for(int j=2; j<su; j++){
                if(su%j==0){
                    flag = false;
                    break;
                }
            }

            if(flag && su != 1) System.out.print(su+" ");
        }
    }
}
