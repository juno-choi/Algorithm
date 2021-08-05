package inflearn.array;

import java.util.Scanner;

/**
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 */
public class PrimeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input = in.nextInt();
        solution(input);
    }

    public static void solution(int input){
        int[] arr = new int[input+1];   //배열을 검사할때 배열과 index값을 맞추기 위해
        int count = 0;
        for(int i=2; i<=input; i++){
            if(arr[i]==0){  //arr[i] == 0일 경우 해당 index는 소수이므로 카운트
                count++;
                for(int j=i; j<=input; j+=i){  //해당 수의 배수들은 모두 체크
                    arr[j] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
