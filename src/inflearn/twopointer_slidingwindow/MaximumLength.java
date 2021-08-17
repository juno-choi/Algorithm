package inflearn.twopointer_slidingwindow;

import java.util.Scanner;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 *
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 *
 * 이며 그 길이는 8입니다.
 */
public class MaximumLength {
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

    public static int solution(int input2, int[] arr){
        int answer = 0;

        int lp = 0;
        int rp = lp;
        int length = 0;
        int count = input2;

        while(rp<arr.length){
            if(count == 0 && arr[rp] == 0){
                length = rp-lp;
                answer = Math.max(answer, length);
                length = 0;
                count = input2;
                lp++;
                rp = lp;
                continue;
            }

            if(arr[rp] == 0){
                count--;
                rp++;
            }else{
                rp++;
            }
        }

        return answer;
    }
    public static int solution2(int input2, int[] arr){
        int answer = 0;
        int cnt = 0;
        int lt = 0;
        int length = arr.length;
        for(int rt = 0; rt<length; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>input2){
                if(arr[lt]==0)cnt--;
                lt++;
            }
            answer=Math.max(answer, rt-lt+1);
        }

        return answer;
    }
}
