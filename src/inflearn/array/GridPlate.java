package inflearn.array;

import java.util.Scanner;

/**
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 */
public class GridPlate {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int leng = in.nextInt();
        int[][] arr = new int[leng][];
        for(int i=0; i<leng; i++){
            int[] arr2 = new int[leng];
            for(int j=0; j<leng; j++){
                arr2[j] = in.nextInt();
            }
            arr[i] = arr2;
        }
        /*int[][] arr = {
                {10, 13, 10, 12, 15},{12, 39, 30, 23, 11},{11, 25, 50, 53, 15},{19, 27, 29, 37, 27},{19, 13, 30, 13, 19}
        };*/
        solution2(arr);
    }

    public static void solution(int[][] arr){
        int max = 0;
        int length = arr.length;
        //열 검사
        for(int i=0; i<length; i++){
            int sum = 0;
            for(int j=0; j<length; j++){
                int su = arr[i][j];
                sum += su;
            }
            max = Math.max(max, sum);
        }
        //행 검사
        for(int i=0; i<length; i++){
            int sum = 0;
            for(int j=0; j<length; j++){
                int su = arr[j][i];
                sum += su;
            }
            max = Math.max(max, sum);
        }
        //대각선 검사1
        int sum1 = 0;
        for(int i=0; i<length; i++){
            int su = arr[i][i];
            sum1 += su;
            max = Math.max(max, sum1);
        }

        //대각선 검사2
        int sum2 = 0;
        for(int i=length-1; i>=0; i--){
            int su = arr[i][i];
            sum2 += su;
            max = Math.max(max, sum2);
        }
        System.out.println(max);
    }

    public static void solution2(int[][] arr){
        int max = 0;
        int length = arr.length;
        int sum1, sum2;
        //행열 검사
        for(int i=0; i<length; i++){
            sum1 = 0;
            sum2 = 0;
            for(int j=0; j<length; j++){
                int su1 = arr[i][j];
                int su2 = arr[j][i];
                sum1 += su1;
                sum2 += su2;
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }
        //대각선 검사1
        sum1=sum2 = 0;
        for(int i=0; i<length; i++){
            int su1 = arr[i][i];
            int su2 = arr[i][length-i-1];
            sum1 += su1;
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }
        System.out.println(max);
    }
}
