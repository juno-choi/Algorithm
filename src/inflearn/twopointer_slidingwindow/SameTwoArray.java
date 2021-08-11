package inflearn.twopointer_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 */
public class SameTwoArray {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr1 = new int[input1];
        for(int i=0; i<input1; i++){
            arr1[i] = in.nextInt();
        }
        int input2 = in.nextInt();
        int[] arr2 = new int[input2];
        for(int i=0; i<input2; i++){
            arr2[i] = in.nextInt();
        }

        ArrayList<Integer> solution = solution(arr1, arr2);
        for (int i : solution) {
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> solution(int[] arr1, int[]arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0;
        int p2 = 0;
        while(p1<arr1.length && p2<arr2.length){
            int su1 = arr1[p1];
            int su2 = arr2[p2];
            //같은지 검사
            if(su1==su2){
                answer.add(su1);
                p1++;
                p2++;
            }else{//아니라면 누가 큰지 검사
                if(su1>su2)
                    p2++;
                else
                    p1++;
            }
        }
        return answer;
    }
}
