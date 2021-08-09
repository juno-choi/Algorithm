package inflearn.array;

import java.util.Scanner;

/**
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 *
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 *
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 */
public class Peaks {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[][] arr = new int[input1][input1];
        for(int i=0; i<input1; i++){
            for(int j= 0; j<input1; j++){
                arr[i][j] = in.nextInt();
            }
        }

        solution2(arr);
    }

    public static void solution(int[][] arr){
        int length = arr.length;
        int count = 0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                int p = arr[i][j];  //기준이 되는 수
                boolean flag = true;
                //상
                if(i>0){
                    if(arr[i-1][j]<p) flag = true;
                    else continue;
                }
                //하
                if(i<length-1 && flag){
                    if(arr[i+1][j]<p) flag = true;
                    else continue;
                }
                //좌
                if(j>0 && flag){
                    if(arr[i][j-1]<p) flag = true;
                    else continue;
                }
                //우
                if(j<length-1 && flag){
                    if(arr[i][j+1]<p) flag = true;
                    else continue;
                }

                if(flag) count++;
            }
        }
        System.out.println(count);
    }

    public static void solution2(int[][] arr){
        int length = arr.length;
        int count = 0;
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                int p = arr[i][j];  //기준이 되는 수
                boolean flag = true;
                for(int h=0; h<x.length; h++){
                    int xd = i+x[h];
                    int yd = j+y[h];
                    if(xd>=0 && yd>=0 && xd<length && yd<length){
                        if(arr[xd][yd]>=p){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag)count++;
            }
        }
        System.out.println(count);
    }
}
