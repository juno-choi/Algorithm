package inflearn.sort;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input2];
        for(int i=0; i<input2; i++){
            arr[i] = in.nextInt();
        }
        int[] solution = solution(arr, input1);
        for (int i : solution) {
            System.out.print(i+" ");
        }
    }

    public static int[] solution(int[] arr, int k){
        int[] answer = new int[k];
        for(int i : arr){

            int idx = answer.length-1;
            //같은 값이 이미 answer에 존재하는지 확인
            for(int j=0; j<answer.length; j++){
                if(i == answer[j]){
                    idx = j;
                    break;
                }
            }

            for(int j=idx; j>0; j--){
                answer[j] = answer[j-1];
            }
            answer[0] = i;
        }

        return answer;
    }
}
