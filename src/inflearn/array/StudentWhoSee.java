package inflearn.array;

import java.util.Scanner;

/**
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 *
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 */
public class StudentWhoSee {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int leng = in.nextInt();
        int[] arr = new int[leng];
        for(int i=0; i<leng; i++){
            int input = in.nextInt();
            arr[i] = input;
        }
        //int[] arr = {160, 135, 148, 140, 145, 150, 150, 153};
        solution(arr);
    }

    public static void solution(int[] arr){
        int length = arr.length;
        int[] arr2 = new int[length+1];
        for(int i=0; i<length; i++){
            arr2[i] = arr[i];
        }
        arr2[length] = 0;

        int cnt = 1;
        int p = arr2[0];
        //전체를 탐색하면서 뒤 번호가 앞번호보다 큰지 확인
        for(int i=1; i<arr2.length; i++){
            int su = arr2[i];
            if(p<su){
                p = su;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
