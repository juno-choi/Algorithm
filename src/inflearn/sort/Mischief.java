package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
 *
 * 철수네 반에는 N명의 학생들이 있습니다.
 *
 * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
 *
 * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
 *
 * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
 *
 * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
 *
 * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
 *
 * 차례로 출력하는 프로그램을 작성하세요.
 */
public class Mischief {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }
        int[] solution = solution(arr);
        for (int i : solution) {
            System.out.print(i+" ");
        }

    }
    public static int[] solution(int[] arr){
        int[] answer = new int[2];
        int[] compare = arr.clone();
        Arrays.sort(compare);
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != compare[i]) answer[idx++] = i+1;
        }

        return answer;
    }

}
