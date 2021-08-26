package inflearn.sort;

import java.util.Scanner;

/**
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 삽입정렬입니다.
 */
public class InsertSort {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }
        solution(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void solution(int[] arr){

        int length = arr.length;
        for(int i=1; i<length; i++){
            int temp = arr[i];
            int j=0;
            for(j=i-1; j>=0; j--){
                if(arr[j]>temp)
                    arr[j+1] = arr[j];
                else
                    break;
            }
            arr[j+1] = temp;
        }
    }
}
