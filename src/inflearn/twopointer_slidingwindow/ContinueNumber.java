package inflearn.twopointer_slidingwindow;

import java.util.Scanner;

/**
 * N개의 수로 이루어진 수열이 주어집니다.
 *
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 *
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 *
 * 1 2 1 3 1 1 1 2
 *
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 *
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 */
public class ContinueNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input1];

        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }

        int solution = solution2(arr, input2);
        System.out.println(solution);
    }
    public static int solution(int[] arr, int target){
        int p = 0;
        int sum = 0;
        int range = 0;
        int cnt = 0;

        int length = arr.length;

        while(p < length){
            if(p+range>=length){
                p++;
                range = 0;
                sum = 0;
                continue;
            }
            sum += arr[p+range];
            if(sum<target){
                range++;
            }else if(sum == target){
                p++;
                range = 0;
                sum = 0;
                cnt++;
            }else{
                p++;
                range = 0;
                sum = 0;
            }
        }

        return cnt;
    }

    public static int solution2(int[] arr, int m){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int n = arr.length;

        for(int rt = 0; rt<n; rt++){
            sum+= arr[rt];
            if(sum==m) answer++;
            while(sum>=m){
                sum-=arr[lt++];
                if(sum==m)answer++;
            }
        }
        return answer;
    }
}
