package inflearn.twopointer_slidingwindow;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 *
 * 12 1511 20 2510 20 19 13 15
 *
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *
 * 여러분이 현수를 도와주세요.
 */
public class MaximumSale {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }

        int solution = solution2(input2, arr);
        System.out.println(solution);
    }

    //실패
    public static int solution(int input, int[] arr){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        list.add(-1);

        int p = 0;
        logic : while(true){
            int sum = 0;
            for(int i=p; i<input+p; i++){
                int su = list.get(i);
                if(su == -1) break logic;
                sum += su;
            }
            answer = Math.max(answer, sum);
            p++;
        }
        return answer;
    }

    //sliding window algorithm
    public static int solution2(int n, int[] arr){
        int answer = 0;
        int sum = 0;
        //n까지 먼저 값을 구하고
        for(int i=0; i<n; i++){
            answer += arr[i];
        }
        sum = answer;
        //다음 값부터는 sliding window 알고리즘으로 구현
        for(int i=n; i<arr.length; i++){
            sum = sum - arr[i-n] + arr[i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
