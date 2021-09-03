package inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 *
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 *
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 *
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 */
public class Stall {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input1];
        for(int i=0; i<input1; i++){
            arr[i] = in.nextInt();
        }
        int solution = solution2(input1, input2, arr);
        System.out.println(solution);
    }
    public static int solution(int m, int k, int[] arr){
        int answer = 0;

        Arrays.sort(arr);   //배열을 우선 정렬
        int max = Arrays.stream(arr).max().getAsInt();  //최댓값
        int min = Arrays.stream(arr).min().getAsInt();  //최솟값

        //마구간의 거리는 최소 0 ~ 최대 max-min 의 거리를 가짐
        int lt = 0;
        int rt = max-min;
        //lt값이 결국 rt보다 커지면 while 종료
        while(lt<=rt){
            int mid = (lt+rt)/2;
            int cnt = count(mid, arr);
            if(cnt>=k){
                lt = mid+1;
                answer = Math.max(answer, mid);
            }else{
                rt = mid-1;
            }
        }

        return answer;
    }
    public static int count(int mid, int[] arr){
        int count = 1;

        //배열에서 mid의 크기만큼 거리에 마구간의 경우 몇개의 말을 넣을 수 있는지 확인
        int stall = arr[0];
        //0번 마구간에는 무조건 말이 들어간다
        for(int i=1; i<arr.length; i++){
            if(arr[i]-stall>=mid){
                count++;
                stall = arr[i];
            }
        }
        return count;
    }

    public static int solution2(int n, int c, int[] arr){
        int answer = 0;

        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count2(arr,mid)>=c){
                answer = mid;
                lt=mid+1;
            }else rt=mid-1;
        }
        return answer;
    }
    //결정 알고리즘에서 count2 메서드를 구현하는게 능력이고 가장 중요한 부분
    public static int count2(int[] arr, int mid){
        int cnt = 1;
        int ep = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep >= mid){
                ep = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
