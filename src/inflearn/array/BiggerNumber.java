package inflearn.array;

import java.util.Scanner;

/**
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 *
 * (첫 번째 수는 무조건 출력한다)
 */
public class BiggerNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int leng = in.nextInt();
        int[] arr = new int[leng];
        for(int i=0; i<leng; i++){
            int input = in.nextInt();
            arr[i] = input;
        }

        solution(arr);
    }

    public static void solution(int[] arr){
        int length = arr.length;
        int[] arr2 = new int[length+1];
        for(int i=0; i<length; i++){
            arr2[i] = arr[i];
        }
        arr2[length] = 0;
        StringBuilder sb = new StringBuilder();

        sb.append(arr2[0]+" ");
        //전체를 탐색하면서 뒤 번호가 앞번호보다 큰지 확인
        for(int i=1; i<arr2.length; i++){
            int su1 = arr2[i-1];
            int su2 = arr2[i];
            if(su1<su2) sb.append(su2+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
