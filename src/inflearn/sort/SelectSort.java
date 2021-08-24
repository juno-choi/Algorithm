package inflearn.sort;

import java.util.Scanner;

/**
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 선택정렬입니다.
 */
public class SelectSort {
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

    /**
     * 선택 정렬은 배열의 0번부터 가장 정렬 방법에 따라 가장 작은수, 가장 큰수를 차례대로 정렬해가는 정렬 방법이다.
     * 시간 복잡도는 O(N^2)을 가진다.
     *
     * 장점 : 구현이 쉽다.
     * 단점 : 오래 걸린다.
     */
    public static void solution(int[] arr){
        int idx = 0;
        while(idx < arr.length){
            for(int i=idx+1; i<arr.length; i++){
                if(arr[i]<arr[idx]) swap(arr, idx, i);
            }
            idx++;
        }
    }
    public static void swap(int[] arr, int m, int k){
        int temp = arr[m];
        arr[m] = arr[k];
        arr[k] = temp;
    }
}
