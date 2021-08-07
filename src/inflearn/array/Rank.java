package inflearn.array;

import java.util.Scanner;

/**
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 *
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 *
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 */
public class Rank {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int leng = in.nextInt();
        int[] arr = new int[leng];
        for(int i=0; i<leng; i++){
            arr[i] = in.nextInt();
        }

        //int[] arr = {87, 89, 92, 100, 76};
        solution(arr);
    }

    public static void solution(int[] arr){
        int[] ranks = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int rank = 1;
            int target = arr[i];
            for(int j=0; j<arr.length; j++){
                if(i==j) continue;
                int compare = arr[j];
                if(target<compare) rank++;
            }
            ranks[i] = rank;
        }
        for (int i : ranks) {
            System.out.print(i+" ");
        }
    }
}
