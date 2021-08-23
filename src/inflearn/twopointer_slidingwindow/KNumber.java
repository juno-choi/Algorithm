package inflearn.twopointer_slidingwindow;

import java.util.*;

/**
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 *
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 *
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 */
public class KNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        int input2 = in.nextInt();
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }
        int solution = solution(input2, arr);
        System.out.println(solution);
    }

    public static int solution(int k, int[] arr){
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int length = arr.length;

        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                for(int h=j+1; h<length; h++){
                    set.add(arr[i]+arr[j]+arr[h]);
                }
            }
        }

        for(int i : set){
            if(k==1) return i;
            else k--;
        }

        return -1;
    }
}
