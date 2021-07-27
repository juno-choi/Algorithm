package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 * 제한 조건
 * n은 1이상 8000000000 이하인 자연수입니다.
 * 입출력 예
 * n	return
 * 118372	873211
 */
public class ReverseSort {
    public static void main(String[] args) {
        ReverseSort t = new ReverseSort();
        long l = 118372;
        long solution = t.solution(l);
        System.out.println("solution = " + solution);
    }
    public long solution(long l) {
        long answer = 0;
        //long을 받아서 decs으로 정령해야함
        char[] chars = String.valueOf(l).toCharArray();
        int leng = chars.length;
        Integer[] arr = new Integer[leng];

        for(int i=0; i<leng; i++){
            arr[i] = chars[i] - '0';    //숫자로 변환
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return 1;
                return -1;
            }
        });

        for(int i=0; i<leng; i++){
            answer += (long) (arr[i] * Math.pow(10,i));
        }
        return answer;
    }
}
