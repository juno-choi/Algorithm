package inflearn.sort;

import java.util.Scanner;

/**
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 버블정렬입니다.
 */
public class BubbleSort {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }

        solution2(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    /**
     * 버블 정렬은 이웃한 배열을 비교하여 오름차순의 경우 가장 큰수가 배열의 가장 끝으로 정렬되는 정렬이다.
     * 시간 복잡도는 O(N^2)을 가진다.
     *
     * 장점 : 구현이 쉽다. 안정된 정렬이다.
     * 단점 : 오래 걸린다.
     */
    public static void solution(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr.length-i; j++){
                if(arr[j]>arr[j+1]) swap(arr, j, j+1);
            }
        }
    }

    public static void solution2(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]) swap(arr, j, j+1);
            }
        }
    }

    public static void swap(int[] arr, int m, int k){
        int temp = arr[m];
        arr[m] = arr[k];
        arr[k] = temp;
    }
}
