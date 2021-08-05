package inflearn.array;

import java.util.Scanner;

/**
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 *
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        solution(input1);
    }
    public static void solution(int input1){
        int[] arr = new int[input1];
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<input1; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }

        for(int i : arr){
            System.out.println("i = " + i);
        }
    }
}
