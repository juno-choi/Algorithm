package inflearn.array;

import java.util.Scanner;

/**
 * 가위바위보 게임
 *
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
 *
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출
 */
public class RockPaperScissors {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[][] arr = new int[2][input1];
        for(int i=0; i<2; i++){
            for(int j= 0; j<input1; j++){
                arr[i][j] = in.nextInt();
            }
        }

        solution(arr);
    }
    public static void solution(int[][] arr){
        int[] first = arr[0];
        int[] second = arr[1];

        for(int i=0; i<first.length; i++){
            int su1 = first[i];
            int su2 = second[i];

            if(su1 == su2){
                System.out.println("D");
            }else if(su1 == 1 && su2 == 2){
                System.out.println("B");
            }else if(su1 == 1 && su2 == 3){
                System.out.println("A");
            }else if(su1 == 2 && su2 == 1){
                System.out.println("A");
            }else if(su1 == 2 && su2 == 3){
                System.out.println("B");
            }else if(su1 == 3 && su2 == 1){
                System.out.println("B");
            }else if(su1 == 3 && su2 == 2){
                System.out.println("A");
            }
        }
    }
}
