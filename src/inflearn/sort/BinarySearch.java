package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 *
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 */
public class BinarySearch {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }
        int solution = solution(input2, arr);
        System.out.println(solution);
    }
    public static int solution(int target, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        //lt와 rt를 선언 lt=시작, rt는 배열의 끝
        //mid를 선언 mid는 lt+rt/2 == 배열의 중앙
        int lt=0;
        int rt = arr.length -1;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==target){
                answer = mid+1;
                break;
            }else if(arr[mid]>target){
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }

        return answer;
    }
}
